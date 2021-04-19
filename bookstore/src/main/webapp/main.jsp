<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="팀프로젝트 중앙문고 홈페이지 입니다" />
<meta name="author" content="김동욱, 김민우, 배석진, 임혜진" />
<link rel="icon" type="image/png" href="resources/main/img/main.png" />
<script src="https://kit.fontawesome.com/7bd2081d90.js" crossorigin="anonymous"></script>
<!-- https://fonts.google.com/specimen/Noto+Sans+KR -->
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="resources/main/css/style.css"/>
<script src="resources/main/js/main.js" defer></script>
<title>중앙문고</title>
</head>
<body>
	<!-- Navbar -->
	<nav id="navbar">
		<div class="navbar__logo">
			<i class="fas fa-book"></i>
			<a href="#">중앙문고</a>
		</div>
		<ul class="navbar__menu">
			<li class="navbar__menu__item active" data-link="#home">Home</li>
			<li class="navbar__menu__item" data-link="#about">About</li>
			<li class="navbar__menu__item" data-link="#work">Work</li>
			<li class="navbar__menu__item" data-link="#contact">Contact</li>
		</ul>
		<!-- Toggle button -->
		<button class="navbar__toggle-btn">
			<i class="fas fa-bars"></i>
		</button>
	</nav>

	<!-- Home -->
	<section id="home">
		<div class="home__container">
			<img src="resources/main/img/main.png" alt="main" class="home__avatar"/>
			<h1 class="home__title">
				팀프로젝트
			</h1>
			<h2 class="home__description">김동욱, 김민우, 배석진, 임혜진</h2>
			<button class="home__contact">Contact Me</button>
		</div>
	</section>
	<!-- About -->
	<section id="about" class="section">
		<div class="section__container">
			<h1>About Team</h1>
			<h3>팀원 김동욱, 김민우, 배석진, 임혜진</h3>
			<div class="abouts">
				<div class="about">
					<img src="resources/main/id/ID_Photo.jpg" alt="People" class="about__avatar" />
					<div class="about__speech-bubble">
						<p>자기 소개 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789</p>
						<p class="name">
							<a href="#">김동욱</a>
						</p>
					</div>
				</div>
				<div class="about">
					<div class="about__speech-bubble">
						<p>팀 프로젝트를 통해서 MVC패턴에 대해서 보다 명확하게 이해할 수 있었고 부족한 점을 채워나가면서 앞으로<br> 개발자로써 나아가야할 방향에  대해서 다시한번 깊게 생각할 수 있는 기회가 되어서 좋았습니다.</p>
						<p class="name">
							<a href="#">김민우</a>
						</p>
					</div>
					<img src="resources/main/id/ID_Photo2.jpg" alt="People" class="about__avatar" />
				</div>
				<div class="about">
					<img src="resources/main/id/ID_Photo3.jpg" alt="People" class="about__avatar" />
					<div class="about__speech-bubble">
						<p>자기 소개 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789</p>
						<p class="name">
							<a href="#">배석진</a>
						</p>
					</div>
				</div>
				<div class="about">
					<div class="about__speech-bubble">
						<p>자기 소개 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789</p>
						<p class="name">
							<a href="#">임혜진</a>
						</p>
					</div>
					<img src="resources/main/id/ID_Photo4.jpg" alt="People" class="about__avatar" />
				</div>
			</div>
		</div>
	</section>

	<!-- TeamWork -->
	<section id="work" class="section">
		<div class="section__container">
			<h1>TeamWork</h1>
			<h3>Projects</h3>
			<div class="work__categories">
				<button class="category__btn selected" data-filter="*">
					전체 <span class="category__count">12</span>
				</button>
				<button class="category__btn" data-filter="Kim-Dong-wook">
					김동욱 <span class="category__count">3</span>
				</button>
				<button class="category__btn" data-filter="Kim-Min-woo">
					김민우 <span class="category__count">3</span>
				</button>
				<button class="category__btn" data-filter="Bae-Seok-jin">
					배석진 <span class="category__count">3</span>
				</button>
				<button class="category__btn" data-filter="Lim-Hye-jin">
					임혜진 <span class="category__count">3</span>
				</button>
				
			</div>
			<div class="work__projects">
				
				<a href="" class="project" target="blank" data-type="Kim-Dong-wook">
					<img class="project__img" src="" alt="회원가입 페이지" />
					<div class="project__description">
						<h3>회원가입 페이지</h3>
						<span>김동욱</span>
					</div>
				</a>
				<a href="" class="project" target="blank" data-type="Kim-Dong-wook">
					<img class="project__img" src="" alt="로그인 페이지" />
					<div class="project__description">
						<h3>로그인 페이지</h3>
						<span>김동욱</span>
					</div>
				</a>
				
				<a href="" class="project" target="blank" data-type="Kim-Dong-wook">
					<img class="project__img" src="" alt="회원 관리 DB" />
					<div class="project__description">
						<h3>회원 관리 DB</h3>
						<span>김동욱</span>
					</div>
				</a>
				
				<a href="" class="project" target="blank" data-type="Kim-Min-woo">
					<img class="project__img" src="resources/main/project/main_page.png" alt="상품 페이지" />
					<div class="project__description">
						<h3>메인 페이지</h3>
						<span>김민우</span>
					</div>
				</a>
				<a href="" class="project" data-type="Kim-Min-woo" target="blank">
					<img class="project__img" src="" alt="상품 목록 페이지" />
					<div class="project__description">
						<h3>상품 목록 페이지</h3>
						<span>김민우</span>
					</div>
				</a> 
				<a href="" class="project" data-type="Kim-Min-woo" target="blank">
					<img class="project__img" src="" alt="상품 상세보기 페이지 " />
					<div class="project__description">
						<h3>상품 상세보기 페이지</h3>
						<span>김민우</span>
					</div>
				</a> 
				
				<a href="" class="project" data-type="Bae-Seok-jin"> 
					<img class="project__img" src="" alt="상품 주문 페이지" />
					<div class="project__description">
						<h3>상품 주문 페이지</h3>
						<span>배석진</span>
					</div>
				</a> 
				<a href="" class="project" data-type="Bae-Seok-jin"> 
					<img class="project__img" src="" alt="장바구니 페이지" />
					<div class="project__description">
						<h3>장바구니 페이지</h3>
						<span>배석진</span>
					</div>
				</a> 
				<a href="" class="project" data-type="Bae-Seok-jin">
					<img class="project__img" src="" alt="결제 페이지" />
					<div class="project__description">
						<h3>결제 페이지</h3>
						<span>배석진</span>
					</div>
				</a> 
				
				<a href="" class="project" data-type="Lim-Hye-jin">
					<img class="project__img" src="" alt="관리자 페이지" />
					<div class="project__description">
						<h3>관리자 페이지</h3>
						<span>임혜진</span>
					</div>
				</a> 
				<a href="" class="project" data-type="Lim-Hye-jin">
					<img class="project__img" src="" alt="상품 등록 페이지" />
					<div class="project__description">
						<h3>상품 등록 페이지</h3>
						<span>임폐진</span>
					</div>
				</a>
				<a href="" class="project" data-type="Lim-Hye-jin">
					<img class="project__img" src="" alt="주문 및 배송 관리" />
					<div class="project__description">
						<h3>주문 및 배송 관리</h3>
						<span>임폐진</span>
					</div>
				</a>
			</div>
		</div>
	</section>

	<!-- Contact -->
	<section id="contact" class="section">
		<h1 class="contact__title">감사합니다</h1>
		<h2 class="contact__email">김동욱 gom0109@gmail.com<br>김민우 thought1128@gmail.com<br>배석진 infoqoch@gmail.com<br>임혜진 hzeen0301@gmail.com</h2>
		<div class="contact__links">
			<a href="https://github.com/thought1128/bookstore" target="_blank"> <i
				class="fab fa-github"></i>
			</a> <a href="<%=request.getContextPath()+"/main.pv"%>" target="_blank"> <i class="fa fa-linkedin-square"></i>
			</a>
		</div>
		<p class="contact__rights">2021 김동욱, 김민우, 배석진, 임혜진 - All rights reserved</p>
	</section>

	<!-- Arrow up -->
	<button class="arrow-up">
		<i class="fas fa-arrow-up"></i>
	</button>
</body>