<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<title>top</title>
</head>
<body>
	<!-- ヘッダー -->
	<header class="py-4">
		<div class="container text-center">
			<h1>
				<a href="/"><img src="/images/logo.png" alt="カフェ Mr. M COFFEE"></a>
			</h1>
		</div>
	</header>
	<!-- /ヘッダー -->
	<nav class="navbar navbar-expand-md navbar-dark sticky-top bg-dark">
		<div class="container">
			<a class="navbar-brand" href="/"><spring:message
					code="coffee.title" /></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbar-content" aria-controls="navbar-content"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- ナビゲーション -->
			<div class="collapse navbar-collapse" id="navbar-content">
				<!-- ナビゲーションメニュー -->
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="#">Top
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Abount</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Menu</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Coupon</a></li>
					<!-- ドロップダウン -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="informationDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">language</a>

						<div class="dropdown-menu" aria-labelledby="informationDropdown">
							<a class="dropdown-item" onclick='languageChange("jp");'>Japan</a>
							<a class="dropdown-item" onclick='languageChange("en");'>English</a>
						</div></li>


				</ul>
			</div>
		</div>
	</nav>

	<!-- メイン -->
	<main>
		<!-- メインビジュアル -->
		<div class="py-4">
			<div class="container">
				<!-- カルーセル外枠 -->
				<div id="main_visual" class="carousel slide" data-ride="carousel">
					<!-- インジケーター -->
					<ol class="carousel-indicators">
						<li data-target="#main_visual" data-slide-to="0" class="active"></li>
						<li data-target="#main_visual" data-slide-to="1"></li>
						<li data-target="#main_visual" data-slide-to="2"></li>
					</ol>
					<!-- / インジケーター -->
					<!-- カルーセル内枠 -->
					<div class="carousel-inner">
						<!-- スライド01 -->
						<div class="carousel-item active">
							<img class="img-fluid" src="/images/slide_01.jpg" alt="コーヒー写真">
							<div class="carousel-caption d-none d-md-block">
								<h2>Mr. M COFFEEのこだわり</h2>
								<p>店主が世界中のコーヒー豆を厳選し、コーヒー豆の種類にあわせ、心を込めて焙煎、抽出しております。</p>
							</div>
						</div>
						<!-- / スライド01 -->
						<!-- スライド02 -->
						<div class="carousel-item">
							<img class="img-fluid" src="/images/slide_02.jpg" alt="ランチ写真">
							<div class="carousel-caption d-none d-md-block">
								<h2>Mr. M COFFEEのメニュー</h2>
								<p>コーヒーはもちろん、モーニングやワンプレートランチ、季節のスイーツなどもご好評いただいております</p>
							</div>
						</div>
						<!-- / スライド02 -->
						<!-- スライド03 -->
						<div class="carousel-item">
							<img class="img-fluid" src="/images/slide_03.jpg" alt="店内写真">
							<div class="carousel-caption d-none d-md-block">
								<h2>Mr. M COFFEEの空間</h2>
								<p>座り心地の良いソファと丁度良い高さのテーブル。くつろぎの空間を満喫してください。</p>
							</div>
						</div>
						<!-- / スライド03 -->
					</div>
					<!-- / カルーセル内枠 -->
					<!-- コントローラー -->
					<a class="carousel-control-prev" href="#main_visual" role="button"
						data-slide="prev"> <span class="carousel-control-prev-icon"
						aria-hidden="true"></span> <span class="sr-only">前に戻る</span>
					</a> <a class="carousel-control-next" href="#main_visual" role="button"
						data-slide="next"> <span class="carousel-control-next-icon"
						aria-hidden="true"></span> <span class="sr-only">次に進む</span>
					</a>
					<!-- / コントローラー -->
				</div>
				<!-- / カルーセル外枠 -->
			</div>
		</div>
		<!-- / メインビジュアル -->
		<!-- コンテンツ01 -->
		<div class="py-4">
			<section id="news">
				<div class="container">
					<div class="row">
						<div class="col-md-2">
							<h3>News</h3>
						</div>
						<div class="col-md-10">
							<dl class="row">
								<dt class="col-md-3">2017年6月4日</dt>
								<dd class="col-md-9">XXXXXXXXXXXXXXXXXXX</dd>
								<dt class="col-md-3 text-truncate">2017年6月3日</dt>
								<dd class="col-md-9 text-truncate">XXXXXXXXXXXXXXXXXXX</dd>
								<dt class="col-md-3">2017年6月2日</dt>
								<dd class="col-md-9">XXXXXXXXXXXXXXXXXXX</dd>
							</dl>
						</div>
					</div>
				</div>
			</section>
		</div>
		<!-- /コンテンツ01 -->
		<!-- コンテンツ02 -->
		<div class="py-4 bg-light">
			<section id="about">
				<div class="container">
					<div class="row mb-4">
						<div class="col-md-8 mb-3">
							<h3>ttttttttttttttttt</h3>
							<p>TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT</p>
							<button class="btn btn-info">メニューを見る</button>
							<a href="#" class="btn btn-info">店舗情報を見る</a>
						</div>
						<div class="col-md-4">
							<img src="/images/about01.jpg" class="img-fluid">
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="card mb-3">
								<img src="/images/about02-thumb.jpg" class="img-fulid">
								<div class="card-body d-flex justify-content-between">
									<h4 class="card-title">雑貨コーナー</h4>
									<button type="button" class="btn btn-secondary">詳しく見る</button>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="card mb-3">
								<img src="/images/about02-thumb.jpg" class="img-fulid">
								<div class="card-body d-flex justify-content-between">
									<h4 class="card-title">雑貨コーナー</h4>
									<button type="button" class="btn btn-secondary">詳しく見る</button>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="card mb-3">
								<img src="/images/about02-thumb.jpg" class="img-fulid">
								<div class="card-body d-flex justify-content-between">
									<h4 class="card-title">雑貨コーナー</h4>
									<button type="button" class="btn btn-secondary">詳しく見る</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<!-- /コンテンツ02 -->
		<!-- コンテンツ03 -->
		<div class="py-4"></div>
		<!-- /コンテンツ03 -->
		<!-- コンテンツ04 -->
		<div class="py-4"></div>
		<!-- /コンテンツ04 -->
		<!-- コンテンツ05 -->
		<div class="py-4"></div>
		<!-- /コンテンツ05 -->
	</main>
	<div
		style="margin-left: 100px; margin-right: 100px; margin-top: 100px;">
		<form:form action="/login?lang=en" method="POST" class="form-signin"
			modelAttribute="topModel">
			<div class="text-center mb-4">
				<h3>ログイン</h3>
			</div>

			<div class="form-label-group">
				<label for="inputEmail">Eメールアドレス</label>
				<form:input path="id" class="form-control" placeholder="Email"></form:input>
			</div>

			<div class="form-label-group">
				<label for="inputPassword">パスワード</label>
				<form:password path="password" class="form-control"
					placeholder="Password"></form:password>
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					パスワードを記憶
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form:form>

		<form:form action="/login?lang=jsss" method="POST" class="form-signin"
			modelAttribute="topModel">
			<div class="text-center mb-4">
				<h3>ログイン</h3>
			</div>

			<div class="form-label-group">
				<label for="inputEmail">Eメールアドレス</label>
				<form:input path="id" class="form-control" placeholder="Email"></form:input>
			</div>

			<div class="form-label-group">
				<label for="inputPassword">パスワード</label>
				<form:password path="password" class="form-control"
					placeholder="Password"></form:password>
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					パスワードを記憶
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form:form>
	</div>
</body>
</html>