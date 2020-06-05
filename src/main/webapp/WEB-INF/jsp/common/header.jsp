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
		<a class="navbar-brand" href="/"><spring:message code="coffee.title" /></a>
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
				<li class="nav-item"><a class="nav-link" href="/user/list"><spring:message code="user.title" /></a></li>
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