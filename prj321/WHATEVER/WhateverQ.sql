CREATE TABLE [dbo].[Book](
	[BookID] [nvarchar](50) NOT NULL,
	[Title] [nvarchar](50) NOT NULL,
	[Author] [nvarchar](50) NULL,
	[Publisher] [nvarchar](50) NULL,
	[Year] [int] NULL,
	[Category] [nvarchar](50) NULL,
	[Language] [nvarchar](50) NULL,
	[Preview] [nvarchar](1000) NULL,
	[Picture] [nvarchar](1000) NULL,
	[Content] [nvarchar](200) NULL,
 CONSTRAINT [PK__Book__3DE0C227E6D8A8A5] PRIMARY KEY CLUSTERED 
(
	[BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Library]    Script Date: 7/4/2020 11:51:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Library](
	[UserID] [nvarchar](50) NOT NULL,
	[BookID] [nvarchar](50) NOT NULL,
	[Time] [date] NULL,
 CONSTRAINT [PK__Library__1788CCAC69B7CE11] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC,
	[BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UserInformation]    Script Date: 7/4/2020 11:51:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserInformation](
	[UserID] [nvarchar](50) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[UserName] [nvarchar](50) NOT NULL,
	[PassWord] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NULL,
	[UserRight] [bit] NULL,
 CONSTRAINT [PK__UserInfo__1788CCAC34B4772E] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Book] ([BookID], [Title], [Author], [Publisher], [Year], [Category], [Language], [Preview], [Picture], [Content]) VALUES (N'B001', N'Tuổi Trẻ Đáng Giá Bao Nhiêu', N'Rosie Nguyễn', N'Nhã Nam', NULL, N'Kỹ Năng Sống', N'Tiếng Việt', N'"Bạn hối tiếc vì không nắm bắt lấy một cơ hội nào đó, chẳng có ai phải mất ngủ.

Bạn trải qua những ngày tháng nhạt nhẽo với công việc bạn căm ghét, người ta chẳng hề bận lòng.

Bạn có chết mòn nơi xó tường với những ước mơ dang dở, đó không phải là việc của họ.

Suy cho cùng, quyết định là ở bạn. Muốn có điều gì hay không là tùy bạn.

Nên hãy làm những điều bạn thích. Hãy đi theo tiếng nói trái tim. Hãy sống theo cách bạn cho là mình nên sống.

Vì sau tất cả, chẳng ai quan tâm."', N'https://media.discordapp.net/attachments/698862234729840733/724922194076893224/TuoCC82CC89i-treCC89-C491aCC81ng-giaCC81-bao-nhieCC82u-review.png', N'https://sachvui.com/sachvui-686868666888/ebooks/2018/pdf/Sachvui.Com-tuoi-tre-dang-gia-bao-nhieu-rosie-nguyen.pdf')
INSERT [dbo].[Book] ([BookID], [Title], [Author], [Publisher], [Year], [Category], [Language], [Preview], [Picture], [Content]) VALUES (N'B002', N'Đừng Lựa Chọn An Nhàn Khi Còn Trẻ', N'Cảnh Thiên', N'Gu Books', NULL, N'Kỹ Năng Sống', N'Tiếng Việt', N'Trong độ xuân xanh phơi phới ngày ấy, bạn không dám mạo hiểm, không dám nỗ lực để kiếm học bổng, không chịu tìm tòi những thử thách trong công việc, không phấn đấu hướng đến ước mơ của mình. Bạn mơ mộng rằng làm việc xong sẽ vào làm ở một công ty nổi tiếng, làm một thời gian sẽ thăng quan tiến chức. Mơ mộng rằng khởi nghiệp xong sẽ lập tức nhận được tiền đầu tư, cầm được tiền đầu tư là sẽ niêm yết trên sàn chứng khoán. Mơ mộng rằng muốn gì sẽ có đó, không thiếu tiền cũng chẳng thiếu tình, an hưởng những năm tháng êm đềm trong cuộc đời mình. Nhưng vì sao bạn lại nghĩ rằng bạn chẳng cần bỏ ra chút công sức nào, cuộc sống sẽ dâng đến tận miệng những thứ bạn muốn? Bạn cần phải hiểu rằng: Hấp tấp muốn mau chóng thành công rất dễ khiến chúng ta đi vào mê lộ. Thanh xuân là khoảng thời gian đẹp đẽ nhất trong đời, cũng là những năm tháng then chốt có thể ', N'https://media.discordapp.net/attachments/698862234729840733/724923005603545139/329274_p86400mscan0001.png', N'https://sachvui.com/sachvui-686868666888/ebooks/2019/pdf/Sachvui.Com-sinh-ra-de-chay-christopher-mcdougall.pdf')
INSERT [dbo].[Book] ([BookID], [Title], [Author], [Publisher], [Year], [Category], [Language], [Preview], [Picture], [Content]) VALUES (N'B003', N'Mặc Kệ Thiên Hạ - Sống Như Người Nhật', N'Mari Tamagawa', N'Skybooks', NULL, N'Kỹ Năng Sống', N'Tiếng Việt', N'Đã đến lúc bạn nên dừng tìm kiếm sự an ủi ở người khác, hoặc chờ đợi sự giúp đỡ từ một ai đó. Bởi an ủi hay giúp đỡ về mặt cảm xúc đôi khi giống như con dao hai lưỡi. Nó có thể giúp bạn chống đỡ lo âu hay muộn phiền nhất thời, nhưng lại đẩy bạn chìm sâu hơn vào những cảm xúc tiêu cực đó. Giống như một đứa trẻ khi vấp ngã, bạn mong đợi một sự xoa dịu từ người lớn, mà quên mất rằng sự “hỗ trợ” ấy chỉ càng khiến bạn mãi chẳng thể nào “biết đi”.
', N'https://media.discordapp.net/attachments/698862234729840733/724923222843326554/mac-ke-thien-ha-song-nhu-nguoi-nhat-1.png?width=703&height=703', N'https://sachvui.com/sachvui-686868666888/ebooks/2018/pdf/Sachvui.Com-mac-ke-thien-ha-song-nhu-nguoi-nhat-mari-tamagawa.pdf')
INSERT [dbo].[Book] ([BookID], [Title], [Author], [Publisher], [Year], [Category], [Language], [Preview], [Picture], [Content]) VALUES (N'B004', N'Nhà Giả Kim', N'Paulo Coelho', N'Nhã Nam', NULL, N'Kỹ Năng Sống', N'Tiếng Việt', N'Tiểu thuyết Nhà giả kim của Paulo Coelho như một câu chuyện cổ tích giản dị, nhân ái, giàu chất thơ, thấm đẫm những minh triết huyền bí của phương Đông. Trong lần xuất bản đầu tiên tại Brazil vào năm 1988, sách chỉ bán được 900 bản. Nhưng, với số phận đặc biệt của cuốn sách dành cho toàn nhân loại, vượt ra ngoài biên giới quốc gia, Nhà giả kim đã làm rung động hàng triệu tâm hồn, trở thành một trong những cuốn sách bán chạy nhất mọi thời đại, và có thể làm thay đổi cuộc đời người đọc.', N'https://media.discordapp.net/attachments/698862234729840733/724923424602062858/Anh-minh-hoa-Nha-gia-kim-e1583778729624.png?width=799&height=703', N'https://sachvui.com/sachvui-686868666888/ebooks/2016/pdf/Sachvui.Com-Nha-Gia-Kim.pdf')
INSERT [dbo].[Book] ([BookID], [Title], [Author], [Publisher], [Year], [Category], [Language], [Preview], [Picture], [Content]) VALUES (N'B005', N'Vui Vẻ Không Qụau Nha', N'Ở Đây Zui Nè', N'Skybooks', NULL, N'Kỹ Năng Sống', N'Tiếng Việt', N'Thôi nào!

Thả lỏng và tận hưởng sự vui vẻ đi. Vì chẳng phải cuộc đời đang ghét bạn đâu, mà chính bạn bạn đang loay hoay với những mệt nhọc ở trên đời. Ví dụ như nay đã là deadline mà bỗng bị rớt mạng, sáng nay đi làm quên đem theo ví, hay đồng nghiệp ở công ty nói xấu mình,


Nếu kể ra thì sẽ có ti tỉ thứ không theo ý mình mỗi ngày. Không nói đến những chuyện bực tức khác, những nỗi buồn chúng ta không làm chủ được, những điều vô tình đến khiến ta quạu cọ và xấu xí. Rồi khi chúng ta cứ để chúng trong lòng sự phiền muộn không biết kéo dài đến bao giờ mới kết thúc.
', N'https://media.discordapp.net/attachments/698862234729840733/724923922444714004/image_195509_1_33312.png', N'https://sachvui.com/sachvui-686868666888/ebooks/2019/pdf/Sachvui.Com-ky-nang-di-truoc-dam-me-cal-newport.pdf')
INSERT [dbo].[Book] ([BookID], [Title], [Author], [Publisher], [Year], [Category], [Language], [Preview], [Picture], [Content]) VALUES (N'B006', N'Mắt Biếc', N'Nguyễn Nhật Ánh', N'NXB Trẻ', NULL, N'Truyện Tình Cảm', N'Tiếng Việt', N'Một tác phẩm được nhiều người bình chọn là hay nhất của nhà văn này. Một tác phẩm đang được dịch và giới thiệu tại Nhật Bản (theo thông tin từ các báo)… Bởi sự trong sáng của một tình cảm, bởi cái kết thúc rất, rất buồn khi suốt câu chuyện vẫn là những điều vui, buồn lẫn lộn (cái kết thúc không như mong đợi của mọi người). Cũng bởi, mắt biếc… năm xưa nay đâu (theo lời một bài hát).', N'https://media.discordapp.net/attachments/698862234729840733/724924161922957332/mat-biec.png?width=1054&height=703', N'https://sachvui.com/sachvui-686868666888/ebooks/2019/pdf/Sachvui.Com-ky-nang-di-truoc-dam-me-cal-newport.pdf')
INSERT [dbo].[Book] ([BookID], [Title], [Author], [Publisher], [Year], [Category], [Language], [Preview], [Picture], [Content]) VALUES (N'B007', N'Sherlock Holmes I', N'Sir Arthur Conan Doyle', N'NXB Văn Học', NULL, N'Tiểu thuyết trinh thám', N'Tiếng Việt', N'Chỉ từ một giọt nước người giỏi suy luận có thể đoán ra rất nhiều chuyện liên quan đến một thác hay một đại dương dù họ chưa bao giờ tận mắt nhìn thấy chúng. Như tất cả mọi khoa học khác, “suy đoán và phân tích” là một khoa học mà ta chỉ có thể làm chủ nó sau một quá trình nghiên cứu lâu dài, bền bỉ.
Sherlock Holmes là thám tử hư cấu nổi danh nhất mọi thời đại. Hơn 100 năm kể từ khi ra đời, Sherlock Holmes với cái mũ phớt và làn khói thuốc bay ra từ chiếc tẩu cùng lối tư duy lạnh lùng đã trở thành hình tượng bất tử về một thám tử tài trí, lừng danh trong dòng văn học trinh thám và được coi như hình mẫu xuất sắc nhất từng có trong thể loại văn học này.', N'https://media.discordapp.net/attachments/698862234729840733/724924340969406534/91UfAl2KhAL.png?width=465&height=714', N'https://sachvui.com/sachvui-686868666888/ebooks/2018/pdf/Sachvui.Com-ban-that-su-co-tai--tina-seelig.pdf')
INSERT [dbo].[Book] ([BookID], [Title], [Author], [Publisher], [Year], [Category], [Language], [Preview], [Picture], [Content]) VALUES (N'B008', N'Cô Dâu Đen', N'Cornell Woolrich', N'NXB Văn Học', NULL, N'Tiểu thuyết trinh thám', N'Tiếng Việt', N'Rùng mình, li kì, hồi hộp. Cô Dâu Đen là một cuốn tiểu thuyết trinh thám hình sự với những bí ẩn kinh dị theo kiểu cổ điển. Tin chắc rằng, sau khi đọc cuốn sách này, nó sẽ ám ảnh bạn trong một thời gian dài. Cách tác giả xây dựng câu chuyện, người đọc như được bao quanh bởi sự mờ hồ. Càng đọc bạn sẽ càng bị lôi cuốn nhiều hơn. Đằng sau tấm khăn choàng cô dâu, hung thủ thật sự là ai?

Từng người một, những người đàn ông đang hấp hối, những cái chết có vẻ như vô tình và chẳng hề liên quan đến nhau. Mối liên kết duy nhất là trước khi chết, người mà các nạn nhân nhìn thấy cuối cùng là một người phụ nữ mặc áo cưới màu đen và những lời nói ngắn ngủi, khó hiểu của cô.
', N'https://media.discordapp.net/attachments/698862234729840733/724924532409761832/67f9f51fdc6655a5bb1eaa0fce0a9ce5.png', N'Cô Dâu Đen.pdf')
INSERT [dbo].[Library] ([UserID], [BookID], [Time]) VALUES (N'U001', N'B001', CAST(N'2020-09-21' AS Date))
INSERT [dbo].[Library] ([UserID], [BookID], [Time]) VALUES (N'U001', N'B004', CAST(N'2020-12-12' AS Date))
INSERT [dbo].[Library] ([UserID], [BookID], [Time]) VALUES (N'U001', N'B006', CAST(N'2020-03-16' AS Date))
INSERT [dbo].[Library] ([UserID], [BookID], [Time]) VALUES (N'U001', N'B007', CAST(N'2020-09-21' AS Date))
INSERT [dbo].[Library] ([UserID], [BookID], [Time]) VALUES (N'U002', N'B001', CAST(N'2020-09-21' AS Date))
INSERT [dbo].[Library] ([UserID], [BookID], [Time]) VALUES (N'U002', N'B003', CAST(N'2020-05-21' AS Date))
INSERT [dbo].[Library] ([UserID], [BookID], [Time]) VALUES (N'U003', N'B005', CAST(N'2020-09-21' AS Date))
INSERT [dbo].[Library] ([UserID], [BookID], [Time]) VALUES (N'U004', N'B007', CAST(N'2020-10-02' AS Date))
INSERT [dbo].[Library] ([UserID], [BookID], [Time]) VALUES (N'U005', N'B002', CAST(N'2020-05-22' AS Date))
INSERT [dbo].[UserInformation] ([UserID], [Name], [UserName], [PassWord], [Email], [UserRight]) VALUES (N'U001', N'Nguyễn Duy Hưng', N'Hung132', N'123456', N'hungu21@gmail.com', 0)
INSERT [dbo].[UserInformation] ([UserID], [Name], [UserName], [PassWord], [Email], [UserRight]) VALUES (N'U002', N'Lê Thị Thanh Nhàn', N'Nhan2910', N'123456', N'Nhangu29@gmail.com', 1)
INSERT [dbo].[UserInformation] ([UserID], [Name], [UserName], [PassWord], [Email], [UserRight]) VALUES (N'U003', N'Nguyễn Văn Huy', N'HuyXaki', N'123456', N'Huyxaki163@gmail.com', 0)
INSERT [dbo].[UserInformation] ([UserID], [Name], [UserName], [PassWord], [Email], [UserRight]) VALUES (N'U004', N'Hoàng MY', N'Hoangmy', N'123456', N'HoangMy291@gmail.com', 0)
INSERT [dbo].[UserInformation] ([UserID], [Name], [UserName], [PassWord], [Email], [UserRight]) VALUES (N'U005', N'Lưu Phương Uyên', N'Phuonguyen', N'123456', N'Phuonguyen09@gmail.com', 0)
ALTER TABLE [dbo].[Library]  WITH CHECK ADD  CONSTRAINT [PK_BOOK] FOREIGN KEY([BookID])
REFERENCES [dbo].[Book] ([BookID])
GO
ALTER TABLE [dbo].[Library] CHECK CONSTRAINT [PK_BOOK]
GO
ALTER TABLE [dbo].[Library]  WITH CHECK ADD  CONSTRAINT [PK_USER] FOREIGN KEY([UserID])
REFERENCES [dbo].[UserInformation] ([UserID])
GO
ALTER TABLE [dbo].[Library] CHECK CONSTRAINT [PK_USER]
GO
select* from Book;
select* from [Library]
select* from UserInformation