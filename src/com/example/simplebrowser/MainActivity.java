package com.example.simplebrowser;

import com.example.simplebrowser.MyWebChromeClient;
import com.example.simplebrowser.MyWebViewClient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity
	implements OnClickListener
{
	private static final String API_URL = "http://chart.apis.google.com/chart?cht=qr&chs=300x300&choe=UTF-8&chl=";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Activityにプログレスバーを表示可能にする。
        requestWindowFeature(Window.FEATURE_PROGRESS);

        setContentView(R.layout.main);

        Button btn = (Button)findViewById(R.id.btn_browse);
        btn.setOnClickListener(this);
        Button btn_qr = (Button)findViewById(R.id.btn_qr);
        btn_qr.setOnClickListener(this);

        WebView webview = (WebView)findViewById(R.id.webview);

        //JavaScriptを実行させるように設定
        webview.getSettings().setJavaScriptEnabled(true);

        //カスタムしたWebChromeClientを設定
        webview.setWebChromeClient(new MyWebChromeClient(this));

        //カスタムしたWebViewClientを設定
        webview.setWebViewClient(new MyWebViewClient(this));
    }

    public void onClick(View v){
    	int id = v.getId();
    	switch(id)
    	{
    	case R.id.btn_browse:
    		//更新ボタン（EditTextに入力されたURLをWebViewで表示させる）
    		EditText edit = (EditText)findViewById(R.id.edit_url);
    		WebView webView = (WebView)findViewById(R.id.webview);
    		//WebViewClientを組み込んでクライアント動作を管理する
    		//（ページを移動する際、他のアプリが起動するのではなくこのWebView内で処理させる）
    		//※別クラス化（MyWebViewClient）
//    		webView.setWebViewClient(new WebViewClient());

    		//指定したURLをロードする
    		webView.loadUrl(edit.getText().toString());

    		//入力フォームの入力を有効にする
    		webView.requestFocus(View.FOCUS_DOWN);
    		break;
    	case R.id.btn_qr:
    		//更新ボタン（EditTextに入力されたURLをWebViewで表示させる）
    		EditText edit2 = (EditText)findViewById(R.id.edit_url);
    		WebView webView2 = (WebView)findViewById(R.id.webview);

    		//指定したURLをロードする
    		webView2.loadUrl(API_URL + edit2.getText().toString());
    	}
    }
}