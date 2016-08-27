insert into users (birth_date, email, name, password, profile_url, sex, token) values ('890523', 'ekdxhrl0096@daum.net', '김성진', '3bfb730ef7a648b784fb249e11b79cc1', 'http://52.78.120.152/profile/seongjin.jpg', '남', '653ab858-ce05-4f29-9652-fa1f7b6ad1c8');
insert into users (birth_date, email, name, password, profile_url, sex, token) values ('890523', 'dlxogjs89@daum.net', '이태헌', '3bfb730ef7a648b784fb249e11b79cc1', 'http://52.78.120.152/profile/etae.jpg', '남', '44a6d1ff-a7ca-4f32-a419-76510d79532e');
insert into users (birth_date, email, name, password, profile_url, sex, token) values ('910523', 'alstjd91@daum.net', '강민성', '3bfb730ef7a648b784fb249e11b79cc1', 'http://52.78.120.152/profile/meenseong.jpg', '남', '44a6d1af-a7ca-4f32-a419-76510d79532e');
insert into users (birth_date, email, name, password, profile_url, sex, token) values ('940523', 'hihi94@daum.net', '강민성', '3bfb730ef7a648b784fb249e11b79cc1', 'http://52.78.120.152/profile/heongji.jpg', '', '44a6d1ff-a7cf-4f32-a419-76510d79532e');
insert into users (birth_date, email, name, password, profile_url, sex, token) values ('930523', 'guswjd93@daum.net', '김현정', '3bfb730ef7a648b784fb249e11b79cc1', 'http://52.78.120.152/profile/hungjin.jpg', '여', '44a6deef-a7ca-4f32-a419-76510d79532e');
insert into users (birth_date, email, name, password, profile_url, sex, token) values ('910523', 'gpdla91@daum.net', '최혜임', '3bfb730ef7a648b784fb249e11b79cc1', 'http://52.78.120.152/profile/haeim.jpg', '여', '44a6d1bb-a7ca-4f32-a419-76510d79532e');

INSERT INTO regions (description, name, notice) VALUES ("서울시 창전동 지역입니다. 재밌는 사람들 많이 들어와요~~!", "서울시 창전동", "벙개해요~ 위치는 단체톡으로 공유드릴게요!");
INSERT INTO regions (description, name, notice) VALUES ("이천시 창전동!! 어여 들어와라!", "이천시 창전동", "이천시 창전동 운영자 구해요!!");
INSERT INTO regions (description, name, notice) VALUES ("서울시 서강동 긴 말은 생략한다.", "서울시 서강동", "가입해주셔서 감사합니다!");

INSERT INTO user_region (region_id, user_id) VALUES (1, 1);
INSERT INTO user_region (region_id, user_id) VALUES (2, 1);
INSERT INTO user_region (region_id, user_id) VALUES (3, 2);

INSERT INTO category (type) VALUES ('HELP');
INSERT INTO category (type) VALUES ('HELLO');
INSERT INTO category (type) VALUES ('FREE');
INSERT INTO category (type) VALUES ('SHOPPING');
INSERT INTO category (type) VALUES ('LIGHTNING');

INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '1', '쿠팡에서 5kg 황금고구마 같이 나눠서 사요!', '황금고구마, 1kg 3500원, 4명', '1', '0', '1', '2016-08-21 16:27:10');
INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '1', '고독이란 불현듯 찾아오는 것', '고독한 남자입니다.', '1', '0', '2', '2016-08-21 16:27:12');
INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '1', '코딩 잘하시는 분??? 개발 좀 알려주세요!!', '코딩 좀 알려주세요!!', '1', '0', '4', '2016-08-21 16:27:14');
INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '1', '집에서 코딩만 하기 너무 힘들다... ㅠㅠ 놀고 싶다!! 맥주 드실분!!', '강남 맥주 마시러 가실 분 구함구함!!', '1', '0', '1', '2016-08-21 16:27:15');
INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '5', '불금인데 닭날다에서 치맥 어때요?', '홍대 닭날다, 17일 금요일, 7시 ', '1', '0', '1', '2016-08-21 16:27:17');
INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '4', '티몬에서 5kg 황금고구마 같이 나눠서 사요!', '황금고구마, 티몬에서 공구!! 4명', '1', '0', '1', '2016-08-21 16:27:18');
INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '5', '위메프에서 5kg 황금고구마 같이 나눠서 사요!', '황금고구마, 위메프에서 공구!! 2명', '1', '0', '1', '2016-08-21 16:27:20');

INSERT INTO participation (article_id, participated_at, user_id) VALUES ('1', '2016-08-21 16:27:33', '1');
INSERT INTO participation (article_id, participated_at, user_id) VALUES ('1', '2016-08-21 16:27:36', '2');
INSERT INTO participation (article_id, participated_at, user_id) VALUES ('2', '2016-08-21 16:27:36', '1');
INSERT INTO participation (article_id, participated_at, user_id) VALUES ('2', '2016-08-21 16:27:36', '2');
INSERT INTO participation (article_id, participated_at, user_id) VALUES ('3', '2016-08-21 16:27:36', '1');
INSERT INTO participation (article_id, participated_at, user_id) VALUES ('3', '2016-08-21 16:27:36', '2');

INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', '쿠팡 5kg에 얼마인가요???', '2016-08-21 16:27:33', '1');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', '글쎄요... 같이 사면 싸지 않을까요??', '2016-08-21 16:27:33', '2');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', '어여~ 가격을 알아보고 알려달라구! 세상세상 현기증 난단 말야.', '2016-08-21 16:27:33', '1');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', '네 ㅎㅎ;;', '2016-08-21 16:27:33', '2');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', '쿠팡 5kg에 xx만원이네요!!', '2016-08-21 16:27:33', '2');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', '혜임 언니 고구마 엄청 싸요!!', '2016-08-21 16:27:33', '5');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', '그렇네!! 세상세상!!!', '2016-08-21 16:27:33', '6');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', '같이사요!!', '2016-08-21 16:27:33', '5');

INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('2', '민성아 왜 또 그러니??', '2016-08-21 16:27:33', '1');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('2', '힘내 ㅠㅡㅠ 그러지마...', '2016-08-21 16:27:33', '2');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('2', '나는 오늘도 고독과 함께 한다.', '2016-08-21 16:27:33', '3');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('2', '오빠... 무서워요.. ㅠㅠ', '2016-08-21 16:27:33', '4');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('2', '지그미니!!! 고독타이밍!!', '2016-08-21 16:27:33', '5');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('2', '지그미니!!! 고독타이밍!!', '2016-08-21 16:27:33', '6');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('2', '지그미니!!! 고독타이밍!!', '2016-08-21 16:27:33', '1');

INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('3', '맥주 고고 하실 분!', '2016-08-21 16:27:33', '2');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('3', '나는 오늘도 고독과 함께 맥주를 마신다.', '2016-08-21 16:27:33', '3');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('3', '오빠... 쏘맥 아니면 저 안마셔요..', '2016-08-21 16:27:33', '4');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('3', '지그미니!!! 술 타이밍!!', '2016-08-21 16:27:33', '5');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('3', '지그미니!!! 술 타이밍!!', '2016-08-21 16:27:33', '6');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('3', '지그미니!!! 술 타이밍!!', '2016-08-21 16:27:33', '1');
