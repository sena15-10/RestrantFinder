package com.example.restaurantfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.restaurantfinder.ui.theme.RestaurantFinderTheme
//あなたは経験豊富なAndroidアプリのUI/UXデザイナーです。
//現在、Jetpack Composeを用いて学習用の「飲食店検索アプリ」を開発しています。
//
//以下の要件を満たす、モダンで使いやすく、かつ学習者が実装しやすいUI構成の提案をお願いします。
//
//**【アプリの主要機能】**
//1. **検索機能:** ユーザーがキーワードを入力し、現在地（緯度経度）周辺の飲食店を検索できる。
//2. **結果表示（リスト）:** 検索結果をスクロール可能なリストで表示する（店名、写真、簡単なアクセス情報を表示）。
//3. **結果表示（マップ）:** 検索結果をGoogleマップ上にピンで表示する。
//
//**【依頼したいこと】**
//1. **画面構成案:** アプリ全体の画面遷移（ナビゲーション）の構造。
//2. **トップ画面のレイアウト案:** 検索バーと結果表示をどのように配置するかの具体的なアイデア。
//3. **表示切替のアイデア:** 「リスト表示」と「マップ表示」をどのように切り替えるのが直感的か、具体的なUI部品（タブ、ボタンなど）の提案。
//
//Jetpack Composeの標準的なコンポーネント（Scaffold, TopAppBar, NavigationBarなど）を使った構成案だと嬉しいです。
//APIキーdd08613a4b3c75ae
object NetworkConfig {
    const val API_KEY = "dd08613a4b3c75ae"
    const val BASE_URL = "https://webservice.recruit.co.jp/hotpepper/"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RestaurantFinderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RestaurantFinderTheme {
        Greeting("Android")
    }
}