USE [EProject1]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](30) NOT NULL,
	[email] [nvarchar](100) NOT NULL,
	[pass] [nvarchar](50) NOT NULL,
	[phone] [nvarchar](14) NOT NULL,
	[adress] [nvarchar](200) NULL,
	[birth] [nvarchar](10) NOT NULL,
	[gender] [bit] NOT NULL,
	[typeadmin] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Slide]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Slide](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[slide] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Servicer]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Servicer](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_category] [int] NOT NULL,
	[name] [nvarchar](300) NOT NULL,
	[contents] [nvarchar](200) NOT NULL,
	[price] [float] NULL,
	[images] [nvarchar](1000) NOT NULL,
	[descriptions] [nvarchar](max) NOT NULL,
	[day_completion] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Project]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Project](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_user] [int] NULL,
	[start_time] [nvarchar](100) NOT NULL,
	[total_price] [float] NULL,
	[phone] [int] NOT NULL,
	[addresss] [nvarchar](200) NOT NULL,
	[avatar] [nvarchar](max) NULL,
	[more] [nvarchar](3000) NULL,
	[startus] [int] NULL,
	[time_request] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderService]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderService](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_project] [int] NULL,
	[id_service] [int] NULL,
	[price_service] [float] NULL,
	[hour_service] [int] NULL,
	[name_service] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[News]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[News](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](200) NOT NULL,
	[desciption] [nvarchar](3000) NOT NULL,
	[currentDate] [nvarchar](max) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Logo]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Logo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[logo] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Home]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Home](
	[logo] [nvarchar](max) NULL,
	[title] [nvarchar](200) NULL,
	[content1] [nvarchar](277) NULL,
	[content2] [nvarchar](277) NULL,
	[content3] [nvarchar](277) NULL,
	[rootUpload] [nvarchar](200) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Faq]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Faq](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[questions] [nvarchar](200) NOT NULL,
	[response] [nvarchar](3000) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[District]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[District](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contact]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[company] [nvarchar](100) NOT NULL,
	[phone] [nvarchar](12) NOT NULL,
	[fax] [nvarchar](12) NOT NULL,
	[email] [nvarchar](200) NULL,
	[address1] [nvarchar](100) NOT NULL,
	[address2] [nvarchar](100) NOT NULL,
	[contry] [nvarchar](50) NOT NULL,
	[timeIn1] [nvarchar](5) NULL,
	[timeOut1] [nvarchar](5) NULL,
	[timeIn2] [nvarchar](5) NULL,
	[timeOut2] [nvarchar](5) NULL,
	[content] [nvarchar](1000) NULL,
	[title] [nvarchar](200) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CommentProject]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CommentProject](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_user] [int] NOT NULL,
	[id_project] [int] NOT NULL,
	[time_content] [nvarchar](100) NULL,
	[content] [nvarchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Comment](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[phone] [nvarchar](12) NOT NULL,
	[body] [nvarchar](1000) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Category]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[id_district] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_user] [int] NOT NULL,
	[id_dis] [int] NOT NULL,
	[name_service] [nvarchar](100) NULL,
	[price_service] [float] NULL,
	[day_service] [int] NULL,
	[image_service] [nvarchar](max) NULL,
	[id_service] [int] NULL,
	[quatity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[About]    Script Date: 07/10/2014 06:20:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[About](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](300) NOT NULL,
	[descriptions] [nvarchar](1000) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Default [DF__Users__adress__7C4F7684]    Script Date: 07/10/2014 06:20:59 ******/
ALTER TABLE [dbo].[Users] ADD  DEFAULT (N'unknowns') FOR [adress]
GO
/****** Object:  Default [DF__Users__typeadmin__7D439ABD]    Script Date: 07/10/2014 06:20:59 ******/
ALTER TABLE [dbo].[Users] ADD  DEFAULT ((0)) FOR [typeadmin]
GO
/****** Object:  Default [DF__Servicer__price__282DF8C2]    Script Date: 07/10/2014 06:20:59 ******/
ALTER TABLE [dbo].[Servicer] ADD  DEFAULT ((0.0)) FOR [price]
GO
/****** Object:  Default [DF__Project__startus__6AEFE058]    Script Date: 07/10/2014 06:20:59 ******/
ALTER TABLE [dbo].[Project] ADD  DEFAULT ((1)) FOR [startus]
GO
