insert into users (birth_date, email, name, password, profile_url, sex, token) values ('890523', 'ekdxhrl0096@daum.net', '아이유1', '3bfb730ef7a648b784fb249e11b79cc1', 'http://52.78.120.152/profile/iu.jpg', '', '653ab858-ce05-4f29-9652-fa1f7b6ad1c8');
insert into users (birth_date, email, name, password, profile_url, sex, token) values ('890523', 'ekdxhrl@daum.net', '아이유2', '3bfb730ef7a648b784fb249e11b79cc1', 'http://52.78.120.152/profile/iu.jpg', '여', '44a6d1ff-a7ca-4f32-a419-76510d79532e');

INSERT INTO regions (description, name, notice) VALUES ("description 1", "Region 1", "notice 1!");
INSERT INTO regions (description, name, notice) VALUES ("description 2", "Region 2", "notice 2!");
INSERT INTO regions (description, name, notice) VALUES ("description 3", "Region 3", "notice 3!");

INSERT INTO user_region (region_id, user_id) VALUES (1, 1);
INSERT INTO user_region (region_id, user_id) VALUES (2, 1);
INSERT INTO user_region (region_id, user_id) VALUES (3, 2);

INSERT INTO category (type) VALUES ('HELP');
INSERT INTO category (type) VALUES ('HELLO');
INSERT INTO category (type) VALUES ('FREE');
INSERT INTO category (type) VALUES ('SHOPPING');
INSERT INTO category (type) VALUES ('LIGHTNING');

INSERT INTO participation (participant_count, recent_participated_date, user_id) VALUES ('13', '2016-08-21 16:27:33', '1');
INSERT INTO participation (participant_count, recent_participated_date, user_id) VALUES ('13', '2016-08-21 16:27:33', '1');

INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at, participation_id) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '1', '쿠팡에서 5kg 황금고구마 같이 나눠서 사요!', '황금고구마, 1kg 3500원, 4명', '1', '0', '1', '2016-08-21 16:27:33', '1');
INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at, participation_id) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '3', '오랜만에 집에 있으려니 심심하네요 :(', '오늘은 공강!!', '1', '0', '1', '2016-08-21 16:27:33', '2');
INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at, participation_id) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '5', '불금인데 닭날다에서 치맥 어때요?', '홍대 닭날다, 17일 금요일, 7시 ', '1', '0', '1', '2016-08-21 16:27:33', null);
INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at, participation_id) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '4', '세상세상 article contents 4 쿠팡에서 5kg 황금고구마 같이 나눠서 사요!', 'article Name 3', '1', '0', '1', '2016-08-21 16:27:33', null);
INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at, participation_id) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '5', '세상세상 article contents 5 쿠팡에서 5kg 황금고구마 같이 나눠서 사요!', 'article Name 3', '1', '0', '1', '2016-08-21 16:27:33', null);
INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at, participation_id) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '5', '세상세상 article contents 6 쿠팡에서 5kg 황금고구마 같이 나눠서 사요!', 'article Name 3', '1', '0', '1', '2016-08-21 16:27:33', null);
INSERT INTO article (article_main_image_url, category_id, contents, title, region_id, view_count, user_id, created_at, participation_id) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '1', '세상세상 article contents 7 쿠팡에서 5kg 황금고구마 같이 나눠서 사요', 'article Name 3', '1', '0', '1', '2016-08-21 16:27:33', null);

INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', '세상세상 댓글!!! 쿠팡에서 5kg 황금고구마 같이 나눠서 사요', '2016-08-21 16:27:33', '1');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', '세상세상 댓글!!! 쿠팡에서 5kg 황금고구마 같이 나눠서 사요', '2016-08-21 16:27:33', '2');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', '세상세상 댓글!!! 쿠팡에서 5kg 황금고구마 같이 나눠서 사요', '2016-08-21 16:27:33', '1');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', '세상세상 댓글!!! 쿠팡에서 5kg 황금고구마 같이 나눠서 사요', '2016-08-21 16:27:33', '2');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', 'Article 1 Comment', '2016-08-21 16:27:33', '2');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', 'Article 1 Comment', '2016-08-21 16:27:33', '1');