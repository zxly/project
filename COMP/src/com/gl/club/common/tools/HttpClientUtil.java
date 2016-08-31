package com.gl.club.common.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
public class HttpClientUtil {

	/**
     * 发送HTTPS  POST请求
     * @param 要访问的HTTPS地址,POST访问的参数Map对象
     * 返回响应值
     * */
    public String sendHttpsRequestByPost(String url, Map<String, String> params) {
        String responseContent = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        //创建TrustManager（证书管理信任类）
        X509TrustManager xtm = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        //这个好像是HOST验证
        X509HostnameVerifier hostnameVerifier = new X509HostnameVerifier() {
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
            public void verify(String arg0, SSLSocket arg1) throws IOException {}
            public void verify(String arg0, String[] arg1, String[] arg2) throws SSLException {}
            public void verify(String arg0, X509Certificate arg1) throws SSLException {}
        };
        try {
            //TLS1.0与SSL3.0基本上没有太大的差别，可粗略理解为TLS是SSL的继承者，但它们使用的是相同的SSLContext
            SSLContext ctx = SSLContext.getInstance("TLSv1");
            //使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用
            ctx.init(null, new TrustManager[] { xtm }, null);
            //创建SSLSocketFactory
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(ctx,hostnameVerifier);
            //通过SchemeRegistry将SSLSocketFactory注册到我们的HttpClient上
            httpclient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> formParams = new ArrayList<NameValuePair>(); // 构建POST请求的表单参数
            if(null!=params){
	            for (Map.Entry<String, String> entry : params.entrySet()) {
	            formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
	            }
            }

            httpPost.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));
            response = httpclient.execute(httpPost);
            
            HttpEntity entity = response.getEntity(); // 获取响应实体
            if (entity != null) {
                responseContent = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
        	try {
				response.close();
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return responseContent;
    }
    
    /**
     * 发送HTTPS  POST请求 传递json数据
     * @param 要访问的HTTPS地址,POST访问的参数Map对象
     * 返回响应值
     * */
    public String sendHttpsRequestByPost(String url, String jsonStr) {
        String responseContent = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        //创建TrustManager
        X509TrustManager xtm = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        //这个好像是HOST验证
        X509HostnameVerifier hostnameVerifier = new X509HostnameVerifier() {
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
            public void verify(String arg0, SSLSocket arg1) throws IOException {}
            public void verify(String arg0, String[] arg1, String[] arg2) throws SSLException {}
            public void verify(String arg0, X509Certificate arg1) throws SSLException {}
        };
        try {
            //TLS1.0与SSL3.0基本上没有太大的差别，可粗略理解为TLS是SSL的继承者，但它们使用的是相同的SSLContext
            SSLContext ctx = SSLContext.getInstance("TLSv1");
            //使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用
            ctx.init(null, new TrustManager[] { xtm }, null);
            //创建SSLSocketFactory
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(ctx,hostnameVerifier);
            //通过SchemeRegistry将SSLSocketFactory注册到我们的HttpClient上
            httpclient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
            HttpPost httpPost = new HttpPost(url);
            
            StringEntity se = new StringEntity(jsonStr,"application/json","UTF-8");  
            httpPost.setEntity(se);
            
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity(); // 获取响应实体
            if (entity != null) {
                responseContent = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
        	try {
				response.close();
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return responseContent;
    }
    
    
    /**
     * 发送HTTPS  get请求
     * @param 要访问的HTTPS地址,POST访问的参数Map对象
     * <a href="http://my.oschina.net/u/556800" class="referer" target="_blank">@return</a>  返回响应值
     * */
    public String sendHttpsRequestByGet(String url) {
        String responseContent = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        //创建TrustManager
        X509TrustManager xtm = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        //HOST验证
        X509HostnameVerifier hostnameVerifier = new X509HostnameVerifier() {
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
            public void verify(String arg0, SSLSocket arg1) throws IOException {}
            public void verify(String arg0, String[] arg1, String[] arg2) throws SSLException {}
            public void verify(String arg0, X509Certificate arg1) throws SSLException {}
        };
        try {
            //TLS1.0与SSL3.0基本上没有太大的差别，可粗略理解为TLS是SSL的继承者，但它们使用的是相同的SSLContext
            SSLContext ctx = SSLContext.getInstance("TLS");
            //使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用
            ctx.init(null, new TrustManager[] { xtm }, null);
            //创建SSLConnectionSocketFactory
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(ctx,hostnameVerifier);
            //通过SchemeRegistry将SSLSocketFactory注册到我们的HttpClient上
            httpclient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
            HttpGet httpget = new HttpGet(url);
            response = httpclient.execute(httpget);
			// 获取响应实体  
            
            HttpEntity entity = response.getEntity(); // 获取响应实体
            if (entity != null) {
                responseContent = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
        	try {
        		if(response!=null){
        			response.close();
        		}
        		if(httpclient!=null){
        			httpclient.close();
        		}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return responseContent;
    }
    
    
	
    /**
     * 主要连接的请求类型是http
	 * 发送 post请求访问本地应用并根据传递参数不同返回不同结果
	 */
	public String post(String url, List<BasicNameValuePair> formparams) {
		// 创建默认的httpClient实例.  
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost  
		HttpPost httppost = new HttpPost(url);
		// 创建参数队列  
		UrlEncodedFormEntity uefEntity;
		
		CloseableHttpResponse response = null;
		String result = "";
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			System.out.println("executing request " + httppost.getURI());
			response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				System.out.println("--------------------------------------");
				result = EntityUtils.toString(entity, "UTF-8");
				System.out.println("--------------------------------------");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源  
			try {
				response.close();
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
     * 主要连接的请求类型是http
	 * 发送 post请求访问本地应用并根据传递参数不同返回不同结果
	 */
	public String post(String url, String xmlstr) {
		// 创建默认的httpClient实例.  
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost  
		HttpPost httppost = new HttpPost(url);

		CloseableHttpResponse response = null;
		String result = "";
		try {
			httppost.setHeader("Content-type", "text/xml; charset=utf-8");
			StringEntity str = new StringEntity(xmlstr, "UTF-8");
			httppost.setEntity(str);
			System.out.println("executing request " + httppost.getURI());
			response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				System.out.println("--------------------------------------");
				result = EntityUtils.toString(entity, "UTF-8");
				System.out.println("--------------------------------------");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源  
			try {
				response.close();
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
    
	/**
	 * 主要连接的请求类型是http
	 * 发送 get请求
	 */
	public String get(String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String result = "";
		try {
			// 创建httpget.  
			HttpGet httpget = new HttpGet(url);
			// 执行get请求.  
			response = httpclient.execute(httpget);
			// 获取响应实体  
			HttpEntity entity = response.getEntity();
			// 打印响应状态  
			System.out.println(response.getStatusLine());
			if (entity != null) {
				// 打印响应内容长度  
				result = EntityUtils.toString(entity);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源  
			try {
				response.close();
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 主要连接的请求类型是http 
	 * 上传文件
	 */
	public String uploadPost(String url, String fileUrl) {
		String result = "";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httppost = new HttpPost(url);
			FileBody bin = new FileBody(new File(fileUrl));
			StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);

			HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("bin", bin).addPart("comment", comment).build();
			httppost.setEntity(reqEntity);
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				System.out.println(response.getStatusLine());
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					System.out.println("Response content length: " + resEntity.getContentLength());
					result = EntityUtils.toString(resEntity, "UTF-8");
				}
				EntityUtils.consume(resEntity);
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 下载文件
	 * @param url
	 * @param fileName 文件的具体路径
	 * @return
	 */
	public String downLoadMediaFile(String url, String fileName, String zmFileName, String msgType) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        InputStream in = null;
        String playingTime = "0";
        //创建TrustManager
        X509TrustManager xtm = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        //HOST验证
        X509HostnameVerifier hostnameVerifier = new X509HostnameVerifier() {
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
            public void verify(String arg0, SSLSocket arg1) throws IOException {}
            public void verify(String arg0, String[] arg1, String[] arg2) throws SSLException {}
            public void verify(String arg0, X509Certificate arg1) throws SSLException {}
        };
        try {
            //TLS1.0与SSL3.0基本上没有太大的差别，可粗略理解为TLS是SSL的继承者，但它们使用的是相同的SSLContext
            SSLContext ctx = SSLContext.getInstance("TLS");
            //使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用
            ctx.init(null, new TrustManager[] { xtm }, null);
            //创建SSLConnectionSocketFactory
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(ctx,hostnameVerifier);
            //通过SchemeRegistry将SSLSocketFactory注册到我们的HttpClient上
            httpclient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
            HttpGet httpget = new HttpGet(url);
            response = httpclient.execute(httpget);
			// 获取响应实体  
            HttpEntity entity = response.getEntity(); // 获取响应实体
            in = entity.getContent();
            File file = new File(fileName);
            FileOutputStream fout = new FileOutputStream(file);
            int l = -1;
            byte[] tmp = new byte[1024];
            while ((l = in.read(tmp)) != -1) {
                fout.write(tmp, 0, l); // 注意这里如果用OutputStream.write(buff)的话，图片会失真，大家可以试试
            }
            fout.flush();
            fout.close();
            
            //语音处理
            if("voice".equals(msgType)) {
            	//转码
                TranscodeUtil.changeAmrToMp3(fileName, zmFileName);
                //MP3播放时长
                int i = TranscodeUtil.mp3DoingTime(new File(zmFileName));
                playingTime = i+"";
                
            }
            
            //图片
            if("image".equals(msgType)) {
                //备份文件
            	playingTime = "";
            }
            
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
        	try {
        		in.close();
        		response.close();
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return playingTime;
	} 
	
}
