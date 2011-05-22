package com.example.simplebrowser;

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
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Activityにプログレスバーを表示可能にする。
        requestWindowFeature(Window.FEATURE_PROGRESS);

        setContentView(R.layout.main);

        Button btn = (Button)findViewById(R.id.btn_browse);
        btn.setOnClickListener(this);

        WebView webview = (WebView)findViewById(R.id.webview);

        //JavaScriptを実行させるように設定
        webview.getSettings().setJavaScriptEnabled(true);

        //カスタムしたWebViewClientを設定
        webview.setWebViewClient(new MyWebViewClient());
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
    		webView.requestFocus(v.FOCUS_DOWN);
    		break;
    	}
    }
}