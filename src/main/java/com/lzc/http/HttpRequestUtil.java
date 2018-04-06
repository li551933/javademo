package com.lzc.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.security.KeyStore;

public class HttpRequestUtil {

	protected final static Logger logger = LoggerFactory.getLogger(HttpRequestUtil.class);
	private static CloseableHttpClient httpClient = null;

	static {
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(15000).setSocketTimeout(15000)
				.build();
		httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
	}

	/**
	 * 发出POST请求
	 *
	 * @param url     地址
	 * @param content 内容
	 * @return 应答
	 */
	public static String postRequeset(String url, String content) {
		logger.info("url : " + url);
		logger.info("req : " + content);
		CloseableHttpResponse resp = null;
		try {
			HttpPost post = new HttpPost(url);
			StringEntity entity = new StringEntity(content, "UTF-8");
			entity.setChunked(true);
			post.setEntity(entity);

			resp = httpClient.execute(post);
			if (resp != null) {
				HttpEntity ent = resp.getEntity();
				if (ent != null) {
					String result = EntityUtils.toString(ent);
					logger.info("resp : " + result);
					return result;
				}
				logger.error("post response is empty");
			}
		} catch (Exception e) {
			logger.error("post exception: " + e.getMessage());
		} finally {
			if (resp != null) {
				try {
					resp.close();
				} catch (Exception ex) {
				}
			}
		}
		return "";
	}

	/**
	 * 发出GET请求
	 *
	 * @param url 地址
	 * @return 应答
	 */
	public static String getRequest(String url) {
		CloseableHttpResponse resp = null;
		try {
			HttpGet post = new HttpGet(url);
			resp = httpClient.execute(post);
			if (resp != null) {
				HttpEntity ent = resp.getEntity();
				if (ent != null) return EntityUtils.toString(ent);
				logger.error("get response is empty");
			}
		} catch (Exception e) {
			logger.error("get exception: " + e.getMessage());
		} finally {
			if (resp != null) {
				try {
					resp.close();
				} catch (Exception ex) {
				}
			}
		}
		return "";
	}


	/**
	 * 发起https请求
	 *
	 * @param requestUrl    请求地址
	 * @param requestMethod
	 * @param outputStr
	 * @return
	 */
	public static String httpsCertRequest(String requestUrl, String certPrefix, String certPath, String requestMethod, String outputStr) {
		try {
			String result = "";

			String FILE_SUFFIX = ".pfx";
			String filePath = certPath + certPrefix + FILE_SUFFIX;

			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream instream = new FileInputStream(new File(filePath));
			try {
				keyStore.load(instream, certPrefix.toCharArray());
			} finally {
				instream.close();
			}

			// Trust own CA and all self-signed certs
			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, certPrefix.toCharArray()).build();
			// Allow TLSv1 protocol only
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					sslcontext,
					new String[]{"TLSv1"},
					null,
					SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

			CloseableHttpClient httpclient = HttpClients.custom()
					.setSSLSocketFactory(sslsf)
					.build();
			try {
				HttpPost httppost = new HttpPost(requestUrl);
				StringEntity se = new StringEntity(outputStr, "UTF-8");
				httppost.setEntity(se);
				CloseableHttpResponse response = httpclient.execute(httppost);
				try {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(), "utf-8"));
						String text;
						while ((text = bufferedReader.readLine()) != null) {
							result += text;
						}
					}
				} finally {
					if (response != null) response.close();
				}
			} finally {
				if (httpclient != null) httpclient.close();
			}
			return result;
		} catch (ConnectException ce) {
			logger.error("Weixin server connection timed out.", ce);
		} catch (Exception e) {
			logger.error("https request error:{}" + requestUrl, e);
		}
		return "";
	}

}