package com.example.simplebrowser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient
{
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url)
	{
		//URLの再読み込み（リンクをタップした）時にもWebViewに遷移先のURLを読み込ませる
		view.loadUrl(url);

		//trueを返すとアプリケーションで遷移先のURLを処理する
		//falseを返すとWebViewで遷移先のURLを処理する
		return false;
	}
}
