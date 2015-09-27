package com.wu.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.alibaba.fastjson.JSON;
import com.wu.bean.TextMessageBean;
import com.wu.bean.TuLingTextMessageBean;
import com.wu.utils.CheckUtil;
import com.wu.utils.MessageUtil;

public class WeiXinServlet extends HttpServlet {

	private static final String tulingRobot = "http://www.tuling123.com/openapi/api";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获得请求参数
		String signature = req.getParameter("signature");
		// System.out.println("signature\t" + signature);
		String timestamp = req.getParameter("timestamp");
		// System.out.println("timestamp\t" + timestamp);
		String nonce = req.getParameter("nonce");
		// System.out.println("nonce\t" + nonce);
		String echostr = req.getParameter("echostr");
		// System.out.println("echostr\t" + echostr);

		PrintWriter pWriter = resp.getWriter();

		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			// System.out.println("返回数据\t" + echostr);
			pWriter.print(echostr);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pWriter = resp.getWriter();
		try {
			Map<String, String> map = MessageUtil.xml2Map(req);
			if (map.get("MsgType").equals("text")) {
				String string = tuling(map.get("Content"));
				TextMessageBean bean = new TextMessageBean();
				bean.setFromUserName(map.get("ToUserName"));
				bean.setCreateTime("1443356684");
				bean.setContent(JSON.parseObject(string, TuLingTextMessageBean.class).getText());
//				bean.setContent(map.get("Content"));
				bean.setToUserName(map.get("FromUserName"));
				bean.setMsgType("text");
				String temp = MessageUtil.map2xml(bean);
				System.out.println("这是返回的消息\n" + temp);
				pWriter.print(temp);
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pWriter.close();
		}
	}

	public String tuling(String arg) throws IOException {

		String APIKEY = "edb126d0aec7cdc0970bb8f08d73cdfd";
		String INFO = URLEncoder.encode(arg, "utf-8");
		String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
		URL getUrl = new URL(getURL);
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.connect();

		// 取得输入流，并使用Reader读取
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer();
		String line = "";
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();
		// 断开连接
		connection.disconnect();
		System.out.println(sb);
		return sb.toString();
	}

}
