> jf3q.com
>
> 若依
>
> 需求分析（角色、功能）-> 原型图，效果图（axure或墨刀）（图纸）（产品经理）->数据库表设计(项目经理)->开发（SVN）->测试（功能测试->压力测试、禅道）->上线（项目经理、技术骨干、加防火墙）->运维（首年免运维）
>
> [https://www.jf3q.com/utype/article/detail/99/1](https://www.jf3q.com/utype/article/detail/99/1)
>
> 【手游app管理系统】 [https://www.bilibili.com/video/BV1p94y157LB/?p=](https://www.bilibili.com/video/BV1p94y157LB/?p=35&share_source=copy_web&vd_source=fac31245bd39ae5f15cf1d5ae6fe3d5e)1
>

ssm框架：spring, spring mvc, mybatis



![画板](https://cdn.nlark.com/yuque/0/2025/jpeg/43817461/1746073730265-c43a815b-d03e-4a60-9443-e7ca553c9635.jpeg)

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1746149876195-4cb6ea94-9cba-4be2-9787-c56d8a3dddff.png)

## 需求分析（思维导图）
系统功能图

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745544463462-39cd3057-d8a7-43f7-97b2-3bf8547a17b8.png)

## 原型图/效果图(墨刀/axure)
登录页

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745660619651-14ba9a62-a095-4f92-a36f-fb0a3d0e91d5.png)

## 技术选型
后端：springboot2+mybatis+druid+mysql+maven

前端：vue2+router+element

## 工具准备
MySQL 3306 123.com

## 环境配置
### 前端环境
nvm -v

node -v

npm -v

vue镜像（可选）npm config set registry https://registry.npmmirror.com/

npm install -g @vue/cli

vue -V

vue ui(vue2，plugin：vue-router, axios, elementui)

[Element - The world’s most popular Vue UI framework](https://element.eleme.cn/#/zh-CN)

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745551153891-a7cddd84-fb20-490d-ab05-5c314cc6c782.png)

npm run serve

### 后端环境
java -version

mvn -v

mysql

navicat

#### SpringBoot设置
ideal->file->new->project->spring boot server url :[https://start.aliyun.com](https://start.aliyun.com)

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745560029826-0360b339-a3d6-49f0-a580-0e8929260f94.png)

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745560143174-a6e9b6c0-8a61-49b5-b034-1ef977c1ae1b.png)

springboot devtools热部署依赖

#### Maven路径配置
![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745560483805-f2d9a917-e315-4beb-a5ce-7f4072f64b61.png)

maven镜像配置

**<font style="color:rgb(0, 0, 0);background-color:rgb(235, 246, 255);">修改settings.xml文件</font>**

首先，找到Maven的settings.xml文件，通常位于C:\Users\用户名\.m2\目录下。

```xml
<mirrors>
<mirror>
<id>alimaven</id>
<mirrorOf>central</mirrorOf>
<name>aliyun maven</name>
<url>http://maven.aliyun.com/nexus/content/groups/public/</url>
</mirror>
</mirrors>
```

#### 测试controller/TestController
```java
package com.gxh.app_back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "hello springboot!!!";
    }
}

```

启动 [http://localhost:8080/test](http://localhost:8080/test)

#### <font style="color:rgba(0, 0, 0, 0.8);background-color:rgb(235, 246, 255);">热部署</font>
![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745562140200-56f258ef-7904-496e-a7d5-fc29a8d2ba82.png)

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745562245529-f9b7e956-cb60-417f-bc49-f70da392846c.png)

#### 修改默认端口
resources/application.properties

或

resources/application.yml

```yaml
server:
  port: 8888
```

#### 修改banner（横幅、广告、logo）
resources/banner.txt

```yaml
________                  _____       
__  ___/__   ________________(_)_____ 
_____ \__ | / /  _ \_  __ \_  /_  __ \
____/ /__ |/ //  __/  / / /  / / /_/ /
/____/ _____/ \___//_/ /_//_/  \____/ 

```

生成工具 [https://www.bootschool.net/ascii](https://www.bootschool.net/ascii)

## 数据库表设计
beyong_platform_db

### 开发者表 dev_user
| id | 主键 | |
| --- | --- | --- |
| devCode | 开发者账号 | |
| devName | 开发者名称 | |
| devPassword | 开发者密码 | |
| devEmail | 开发者电子邮箱 | |
| devInfo | 开发者简介 | |
| createdBy | 创建者（来源dev_user表中的id） | |
| creationDate | 创建时间 | |
| modifyBy | 更新者（来源dev_user表中的id） | |
| modifyDate | 最近更新时间 | |


**AI**: <font style="color:rgb(26, 32, 41);">生成建表sql语句，需要在表设计中添加注释，再添加一些示例数据插入</font>

### sql
```sql
/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80022
Source Host           : 127.0.0.1:3306
Source Database       : beyond_platform_db

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2024-12-23 18:56:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_category
-- ----------------------------
DROP TABLE IF EXISTS `app_category`;
CREATE TABLE `app_category` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `categoryCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分类编码',
  `categoryName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分类名称',
  `parentId` bigint DEFAULT NULL COMMENT '父级节点id',
  `createdBy` bigint DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=124 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='手游类别';

-- ----------------------------
-- Records of app_category
-- ----------------------------
INSERT INTO `app_category` VALUES ('1', 'ALL_GAME', '全部游戏', null, '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('2', 'GAME_001', '休闲游戏', '1', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('3', 'GAME_002', '益智游戏', '1', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('4', 'GAME_003', '体育游戏', '1', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('5', 'GAME_004', '角色扮演', '1', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('115', 'GAME_004_01_02', '局域网', '28', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('48', 'GAME_001_02_02', '三国类', '20', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('52', 'GAME_002_01_02', '麻将', '22', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('53', 'GAME_002_01_03', '围棋', '22', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('54', 'GAME_002_02_01', '九宫格', '23', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('55', 'GAME_002_02_02', '杀手数独', '23', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('56', 'GAME_002_02_03', '梅花桩数独', '23', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('57', 'GAME_002_03_01', '车内逃脱', '24', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('19', 'GAME_001_01', '养成类', '2', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('20', 'GAME_001_02', '塔防类', '2', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('21', 'GAME_001_03', '消除类', '2', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('22', 'GAME_002_01', '棋牌类', '3', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('23', 'GAME_002_02', '数独类', '3', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('24', 'GAME_002_03', '密室逃脱类', '3', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('25', 'GAME_003_01', '球类', '4', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('26', 'GAME_003_02', '赛车类', '4', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('28', 'GAME_004_01', '射击类', '5', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('120', 'GAME_004_03_02', '多阵营', '42', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('119', 'GAME_004_03_01', '双阵营', '42', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('118', 'GAME_004_02_02', '3D', '41', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('117', 'GAME_004_02_01', '拳皇', '41', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('116', 'GAME_004_01_03', '广域网', '28', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('112', 'GAME_003_02_01', '汽车', '26', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('111', 'GAME_003_01_03', '排球', '25', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('110', 'GAME_003_01_02', '篮球', '25', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('109', 'GAME_003_01_01', '足球', '25', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('58', 'GAME_002_03_02', '房内逃脱', '24', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('41', 'GAME_004_02', '格斗类', '5', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('42', 'GAME_004_03', '策略对战', '5', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('43', 'GAME_004_04', '冒险升级', '5', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('44', 'GAME_001_01_01', '庄园类', '19', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('45', 'GAME_001_01_02', '荒岛类', '19', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('46', 'GAME_001_01_03', '经营类', '19', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('47', 'GAME_001_02_01', '丧尸类', '20', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('49', 'GAME_001_03_01', '同色消除', '21', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('50', 'GAME_001_03_02', '连线消除', '21', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('51', 'GAME_002_01_01', '象棋', '22', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('114', 'GAME_004_01_01', '单机', '28', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('113', 'GAME_003_02_02', '摩托车', '26', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('121', 'GAME_004_03_03', '5V5', '42', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('122', 'GAME_004_04_01', '单机', '43', '1', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('123', 'GAME_004_04_01', '广域网', '43', '11', '2016-08-12 18:11:47', null, null);
INSERT INTO `app_category` VALUES ('59', 'GAME_002_03_03', '其他场景', '24', '1', '2016-08-12 18:11:47', null, null);

-- ----------------------------
-- Table structure for app_info
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `softwareName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '软件名称',
  `apkName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'APK名称（唯一）',
  `supportROM` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '支持ROM',
  `interfaceLanguage` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '界面语言',
  `softwareSize` decimal(20,2) DEFAULT NULL COMMENT '软件大小（单位：M）',
  `updateDate` date DEFAULT NULL COMMENT '更新日期',
  `devId` bigint DEFAULT NULL COMMENT '开发者id（来源于：dev_user表的开发者id）',
  `appInfo` varchar(5000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '应用简介',
  `status` bigint DEFAULT NULL COMMENT '状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）',
  `onSaleDate` datetime DEFAULT NULL COMMENT '上架时间',
  `offSaleDate` datetime DEFAULT NULL COMMENT '下架时间',
  `flatformId` bigint DEFAULT NULL COMMENT '所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）',
  `categoryLevel3` bigint DEFAULT NULL COMMENT '所属三级分类（来源于：data_dictionary）',
  `downloads` bigint DEFAULT NULL COMMENT '下载量（单位：次）',
  `createdBy` bigint DEFAULT NULL COMMENT '创建者（来源于dev_user开发者信息表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint DEFAULT NULL COMMENT '更新者（来源于dev_user开发者信息表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  `categoryLevel1` bigint DEFAULT NULL COMMENT '所属一级分类（来源于：data_dictionary）',
  `categoryLevel2` bigint DEFAULT NULL COMMENT '所属二级分类（来源于：data_dictionary）',
  `logoPicPath` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'LOGO图片url路径',
  `logoLocPath` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'LOGO图片的服务器存储路径',
  `versionId` bigint DEFAULT NULL COMMENT '最新的版本id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of app_info
-- ----------------------------
INSERT INTO `app_info` VALUES ('48', '劲乐团U:O2Jam U', 'com.momocorp.o2jamu', '2.3及更高版本', '英文软件', '56.00', null, '1', '劲乐团U O2Jam U是一款音乐节拍游戏，跟着音乐的节奏点击屏幕即可，就是跳舞机，需要网络支持。\r\n注意：部分机型会卡死在启动界面或fc，结束进程后重新开启游戏就正常了。', '1', null, null, '3', '38', '1000', '1', '2016-08-22 11:43:02', null, null, '2', '19', '/BeyondPlatform/uploadfiles/com.momocorp.o2jamu.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.momocorp.o2jamu.jpg', null);
INSERT INTO `app_info` VALUES ('49', '塔防名将传', 'com.lbe.security', '2.2及更高版本', '简体中文', '9.00', null, '1', '三国塔防名将传是一款手机上的角色扮演类手机游戏，畅爽游戏新激情带来独特的刺激新玩法你在游戏当中也会变得愈加强大，拥有更为强悍的战技多样的冒险等待玩家在游戏里不断的去探索爽快经典优秀的游戏新内容缔造极致', '1', null, null, '1', '48', '2000', '1', '2016-08-22 11:47:11', null, null, '1', '3', '/BeyondPlatform/statics/uploadfiles/com.lbe.security2.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.lbe.security2.jpg', null);
INSERT INTO `app_info` VALUES ('50', '和平精英', 'com.sp.protector.free', '2.3及更高版本', '简体中文', '3.00', null, '2', '《和平精英》采用虚幻4引擎研发，致力于从画面、地图、射击手感等多个层面，为玩家全方位打造出极具真实感的军事竞赛体验。 ', '1', null, null, '1', '116', '5000', '1', '2016-08-22 11:49:12', null, null, '1', '3', '/BeyondPlatform/statics/uploadfiles/com.sp.protector.free2.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.sp.protector.free2.jpg', null);
INSERT INTO `app_info` VALUES ('51', '开心消消乐', 'com.google.android.inputmethod.pinyin', '4.2及更高版本', '简体中文', '16.00', null, '1', '《开心消消乐》是一款三消游戏，游戏画面精美、上手简单。玩家只需滑动手指让三个及以上的同色小动物横竖相连即可消除，完成每关的指定消除目标就可以过关。小动物的滑动还会触发很多神奇的效果，比如在四连直线和横线特效相邻时，两个互相拖动，两者同时触发，构成十字架；四连直线可以产生爆炸特效，使横排或竖排四个目标同时清空。\r\n四连直线+爆炸特效，可构成竖着四排，同时清空！威力很强。\r\n\r\n四连横线+爆炸特效，横向四排同时清空，同样威力很强。\r\n\r\n爆炸特效+爆炸特效，爆炸特效的扩大，同样威力很强。\r\n\r\n但横于竖是随即的，全部化为爆炸特效。这个是很实用的特效，大家一定要牢记。\r\n\r\n五连+五连，极难出现。两者相邻相互拖动，直接清屏，这最后一个纯属机缘巧合，玩家也不要强求。', '1', null, null, '3', '49', '8000', '1', '2016-08-22 11:53:23', null, null, '1', '3', '/BeyondPlatform/statics/uploadfiles/com.google.android.inputmethod.pinying.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.google.android.inputmethod.pinying.jpg', '37');
INSERT INTO `app_info` VALUES ('52', 'QQ飞车手游', 'com.speedsoftware.rootexplorer', '2.3及更高版本', '简体中文', '3.00', null, '1', 'qq飞车手游赛车排行-完美兼容手游,高清大屏,完美画质,给你真实享受.超越手机高端运行,PC深度适配,游戏不卡顿,操控无压力!', '1', null, null, '1', '112', '2340', '1', '2016-08-22 11:55:14', null, null, '1', '3', '/BeyondPlatform/statics/uploadfiles/com.speedsoftware.rootexplorer2.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.speedsoftware.rootexplorer2.jpg', '38');
INSERT INTO `app_info` VALUES ('53', 'FIFA 15:终极队伍', 'com.katecca.screenofflockdonate', '2.2及更高版本', '简体中文', '1.00', null, '1', '《 FIFA 15：终极队伍 FIFA 15 Ultimate Team》是一款由巨头体育游戏公司EA推出的最新款足球体育游戏。游戏中由着真实球员，真实球队，真实联赛，让玩家不用出门也可以在足球场上一展雄风。欢迎 进入安卓智能手机和平板电脑上最真实的足球游戏。以全新的触摸操作感受每次传球和临门一脚的激动时刻。', '1', null, null, '1', '109', '20', '1', '2016-08-22 13:07:11', null, null, '1', '4', '/BeyondPlatform/statics/uploadfiles/com.katecca.screenofflockdonate3.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.katecca.screenofflockdonate3.jpg', null);
INSERT INTO `app_info` VALUES ('54', '复古传奇', 'com.plexnor.gravityscreenoffpro', '2.2及更高版本', '英文软件', '1.00', null, '1', '1', '1', null, null, '1', '58', '23', '1', '2016-08-22 13:08:24', '1', '2024-11-21 20:35:06', '3', '24', '090351d0e9ef4171ba1859224f6be203.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.plexnor.gravityscreenoffpro2.jpg', null);
INSERT INTO `app_info` VALUES ('55', '机械迷城:Machinarium', 'air.net.machinarium.Machinarium.GP', '2.3及更高版本', '英文软件', '11.00', null, '1', '机械迷城Machinarium是一款解密冒险游戏，玩家可以在城市里随意的走动，跟场景或是其他同样是机器人互动，了解他们的需求以及帮忙他们，一步一步往事件的核心探索。 ', '3', null, null, '1', '48', '277', '1', '2016-08-22 13:09:44', '1', '2024-11-21 20:34:37', '2', '20', '95da1998af7c43aa8ce3340497862ec4.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\air.net.machinarium.Machinarium.GP.jpg', '36');
INSERT INTO `app_info` VALUES ('56', 'Dont Starve饥荒', 'com.kleientertainment.doNotStarvePocket', '4.0.3及更高版本', '英文软件', '4.00', null, '1', 'Don`t Starve: Pocket Edition移动版将深受超过4百万玩家喜爱的热门PC游戏移植到了安卓平台。现在你可以随时随地进入充满科学和魔法元素的世界，体验原汁原味的荒野生存游戏！\r\n你扮演威尔逊，一位被困住并传送到神秘荒野世界的勇敢无畏的绅士科学家。如果威尔逊希望逃出生天并找到回家的路，他必须充分利用所处的环境及这里的各种生物。\r\n进入一个光怪陆离而未经探索的世界，这里充满了奇怪的生物以及形形色色的危险和意外。收集资源以制作符合你的生存风格的物品和建筑。一路解开这块奇怪大陆上的各种谜团。', '5', null, '2016-08-22 13:28:16', '2', '45', '390', '1', '2016-08-22 13:11:51', '1', '2024-12-11 15:55:13', '2', '19', '6038888a6c404de6af951c8510c572b6.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.kleientertainment.doNotStarvePocket.jpg', '42');
INSERT INTO `app_info` VALUES ('57', '机械世界:Apparatus', 'com.bithack.apparatus', '1.6及更高版本', '英文软件', '11.00', null, '1', '在机械世界Apparatus游戏中你需要利用木板、钉子、绳索、圆轮等等各种道具搭建从简单到复杂的机械结构，使得小球可以最终滚落到蓝色方框中。可以利用的可不止重力，包括杠杆原理、滑轮等等，尤其是后面的关卡，你需要足够灵活的头脑才能解决问题，可玩性还是非常高的。', '3', null, null, '1', '52', '255', '1', '2016-08-22 13:13:27', '1', '2024-12-03 19:48:16', '3', '22', 'c6d0898ecb364a3c933f5a5a9234b623.png', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.bithack.apparatus.jpg', '41');
INSERT INTO `app_info` VALUES ('58', '沙盘玩具:The Powder Toy', 'com.doodleapps.powdertoy', '2.2及更高版本', '英文软件', '1.00', null, '1', '沙盘玩具The Powder Toy是一款模拟类游戏。想过自己建造核电站吗？或者自己做一个CPU？你甚至可以创建一个虚拟网络。沙盘玩具可以模拟空气的压力，速度，热，重力和无数的不同物质之间的相互作用，游戏提供各种形态的建材，用以构建复杂的机器或是电子元件，你可以模拟超酷的爆炸或是布线出复杂的机器人。欢迎提交您的作品。', '5', null, '2024-11-21 20:31:33', '3', '45', '2000', '1', '2016-08-22 13:14:56', '1', '2024-12-11 15:55:07', '2', '20', 'f7f6839bf5c84cafb3e774698ec6f7c6.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.doodleapps.powdertoy.jpg', '40');
INSERT INTO `app_info` VALUES ('59', '王者荣耀', 'com.timi-wangzherongyao', '2.2及更高版本', '中文软件', '2666.00', null, '1', '一款5V5的公平竞技手游', '5', '2024-11-20 14:43:51', '2024-11-20 14:43:54', '3', '44', '1000', '1', '2020-03-11 18:05:50', '1', '2024-12-11 15:54:53', '2', '19', 'a687747124944ae38804e97a4a6ffd58.png', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.timi-wangzherongyao.png', '43');
INSERT INTO `app_info` VALUES ('86', 'yyyy', 'com.lbe.security123', null, null, null, null, null, null, null, null, null, '1', '48', '10', null, null, null, '2024-12-12 21:26:35', '2', '20', '4030983230794beaa3d1661073d3988f.png', null, null);
INSERT INTO `app_info` VALUES ('88', 'zzzz', 'dfesfe', null, null, null, '2024-12-17', null, null, '1', null, null, '2', '46', null, null, '2024-12-16 16:56:16', null, '2024-12-17 15:06:14', '2', '19', 'a4786d956df047a6996658d52fae5a80.png', null, null);
INSERT INTO `app_info` VALUES ('89', 'zhangsan2', '2432423', null, null, null, '2024-12-18', null, null, '1', null, null, '2', '51', null, null, '2024-12-16 16:56:41', null, '2024-12-18 14:58:20', '3', '22', '9f2c8a7201d44c3a8d4e9e8ea4b6cd8d.jpg', null, null);

-- ----------------------------
-- Table structure for app_version
-- ----------------------------
DROP TABLE IF EXISTS `app_version`;
CREATE TABLE `app_version` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `appId` bigint DEFAULT NULL COMMENT 'appId（来源于：app_info表的主键id）',
  `versionNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '版本号',
  `versionInfo` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '版本介绍',
  `publishStatus` bigint DEFAULT NULL COMMENT '发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）',
  `downloadLink` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '下载链接',
  `versionSize` decimal(20,2) DEFAULT NULL COMMENT '版本大小（单位：M）',
  `createdBy` bigint DEFAULT NULL COMMENT '创建者（来源于dev_user开发者信息表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint DEFAULT NULL COMMENT '更新者（来源于dev_user开发者信息表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  `apkLocPath` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'apk文件的服务器存储路径',
  `apkFileName` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上传的apk文件名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of app_version
-- ----------------------------
INSERT INTO `app_version` VALUES ('33', '58', 'V1.1.1', 'V1.1.1版本简介', '3', '/BeyondPlatform/statics/uploadfiles/com.doodleapps.powdertoy-V1.1.31.apk', '1.00', '1', '2016-08-22 13:17:47', null, null, 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.doodleapps.powdertoy-V1.1.31.apk', 'com.doodleapps.powdertoy-V1.1.31.apk');
INSERT INTO `app_version` VALUES ('34', '57', 'V1.1.1', '              V1.1.1版本简介', '3', '/BeyondPlatform/statics/uploadfiles/com.bithack.apparatus-V1.1.1.apk', '11.00', '1', '2016-08-22 13:19:42', '1', '2016-08-22 13:19:54', 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.bithack.apparatus-V1.1.1.apk', 'com.bithack.apparatus-V1.1.1.apk');
INSERT INTO `app_version` VALUES ('35', '56', 'V1.1.1', '              V1.1.1简介', '2', '/BeyondPlatform/statics/uploadfiles/com.kleientertainment.doNotStarvePocket-V1.1.1.apk', '4.00', '1', '2016-08-22 13:21:12', '1', '2016-08-22 13:28:07', 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.kleientertainment.doNotStarvePocket-V1.1.1.apk', 'com.kleientertainment.doNotStarvePocket-V1.1.1.apk');
INSERT INTO `app_version` VALUES ('36', '55', 'V1.1.1', '              V1.1.1简介', '3', '/BeyondPlatform/statics/uploadfiles/air.net.machinarium.Machinarium.GP-V1.1.1.apk', '11.00', '1', '2016-08-22 13:21:40', '1', '2016-08-22 13:21:57', 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\air.net.machinarium.Machinarium.GP-V1.1.1.apk', 'air.net.machinarium.Machinarium.GP-V1.1.1.apk');
INSERT INTO `app_version` VALUES ('37', '51', 'V1.1.1', 'V1.1.1简介', '3', '/BeyondPlatform/statics/uploadfiles/com.google.android.inputmethod.pinyin-V1.1.1.apk', '16.00', '1', '2016-08-22 13:24:07', null, null, 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.google.android.inputmethod.pinyin-V1.1.1.apk', 'com.google.android.inputmethod.pinyin-V1.1.1.apk');
INSERT INTO `app_version` VALUES ('38', '52', 'V1.1.1', 'V1.1.1简介', '3', '/BeyondPlatform/statics/uploadfiles/com.speedsoftware.rootexplorer-V1.1.1.apk', '3.00', '1', '2016-08-22 13:24:35', null, null, 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.speedsoftware.rootexplorer-V1.1.1.apk', 'com.speedsoftware.rootexplorer-V1.1.1.apk');
INSERT INTO `app_version` VALUES ('39', '58', 'V1.1.2', 'V1.1.2', '3', '/BeyondPlatform/statics/uploadfiles/com.doodleapps.powdertoy-V1.1.2.apk', '2.00', '1', '2016-08-22 13:26:15', null, null, 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.doodleapps.powdertoy-V1.1.2.apk', 'com.doodleapps.powdertoy-V1.1.2.apk');
INSERT INTO `app_version` VALUES ('40', '58', 'V1.1.3', 'V1.1.3简介', '2', '/BeyondPlatform/statics/uploadfiles/com.doodleapps.powdertoy-V1.1.3.apk', '2.00', '1', '2016-08-22 13:26:47', '1', '2016-08-22 13:27:42', 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.doodleapps.powdertoy-V1.1.3.apk', 'com.doodleapps.powdertoy-V1.1.3.apk');
INSERT INTO `app_version` VALUES ('41', '57', 'V1.1.2', '              V1.1.2简介', '3', '/BeyondPlatform/statics/uploadfiles/com.bithack.apparatus-V1.1.2.apk', '11.00', '1', '2016-08-22 13:27:32', '1', '2016-08-22 15:08:04', 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.bithack.apparatus-V1.1.2.apk', 'com.bithack.apparatus-V1.1.2.apk');
INSERT INTO `app_version` VALUES ('42', '56', 'V1.1.2', 'V1.1.2简介', '3', '/BeyondPlatform/statics/uploadfiles/com.kleientertainment.doNotStarvePocket-V1.1.2.apk', '4.00', '1', '2016-08-22 15:00:32', null, null, 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.kleientertainment.doNotStarvePocket-V1.1.2.apk', 'com.kleientertainment.doNotStarvePocket-V1.1.2.apk');
INSERT INTO `app_version` VALUES ('43', '59', 'v_3.4.11', '一款5V5的公平竞技手游', '3', '/BeyondPlatform/statics/uploadfiles/com.timi-wangzherongyao-v_3.4.11.apk', '2999.00', '1', '2020-03-11 18:09:51', '1', '2020-03-11 18:38:44', 'D:\\java\\tomcat\\apache-tomcat-9.0.14\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.timi-wangzherongyao-v_3.4.11.apk', 'com.timi-wangzherongyao-v_3.4.11.apk');
INSERT INTO `app_version` VALUES ('45', '59', 'wdw', 'dwq', null, '67380835fd4a4b52af54b7e8cd71f08a.png', '12.00', '1', '2024-11-18 10:35:39', null, null, null, null);
INSERT INTO `app_version` VALUES ('46', '59', 'sxewfce', 'dewcew', '3', null, '12.00', '1', '2024-11-18 14:46:01', null, null, null, null);
INSERT INTO `app_version` VALUES ('47', '59', '232', '23', '3', 'c09917e0e975491b8e83e9d794b6a915.apk', '321.00', '1', '2024-11-18 14:50:20', null, null, 'D:/upload/appinfo/apk/c09917e0e975491b8e83e9d794b6a915.apk', null);
INSERT INTO `app_version` VALUES ('48', '74', 'srteres', 'e32r', null, 'd3c39560b0c14271984710f6974f0987.apk', '12.00', '1', '2024-11-20 10:28:02', null, null, null, null);
INSERT INTO `app_version` VALUES ('51', '83', 'erwerw', 'r3rw', '3', '8dc28e65c6c24b478c8bf282545f72b0.apk', '12.00', '1', '2024-11-21 21:36:45', null, null, 'D:/upload/appinfo/apk/8dc28e65c6c24b478c8bf282545f72b0.apk', null);
INSERT INTO `app_version` VALUES ('52', '84', '3e2e43', '323', '3', '24026e213e8c4eb29cbb90e2110bc927.apk', '12.00', '1', '2024-11-21 22:00:30', null, null, 'D:/upload/appinfo/apk/24026e213e8c4eb29cbb90e2110bc927.apk', null);
INSERT INTO `app_version` VALUES ('54', '59', 'erw', '12', '3', 'd743b8117e0f47758b5bdb90f4d0eac5.apk', '12.00', null, '2024-12-04 23:45:07', null, null, null, null);
INSERT INTO `app_version` VALUES ('55', '59', 'erw', '12', '3', '64203bbab4d84e0a9952cb476c068314.apk', '12.00', null, '2024-12-04 23:46:38', null, null, null, null);
INSERT INTO `app_version` VALUES ('56', '59', '55555', '12', '3', '6e2dc110d2a642af8cdd6cd9796cca28.apk', '12.00', null, '2024-12-04 23:49:57', null, null, null, null);
INSERT INTO `app_version` VALUES ('57', '57', '23123', '12', '3', '23b5391cf4a74edfae99b558fd9db8d9.apk', '12.00', null, '2024-12-04 23:51:05', null, null, null, null);
INSERT INTO `app_version` VALUES ('58', '57', '5645645', '12', '3', '3d290df72f15445b920bb8175b32da27.apk', '12.00', null, '2024-12-04 23:51:24', null, null, null, null);
INSERT INTO `app_version` VALUES ('60', '59', 'erwerw11', '121', '3', null, '12.00', null, '2024-12-10 14:33:43', null, null, null, '424e28b934454984ba45f8a41ed3b9bb.apk');
INSERT INTO `app_version` VALUES ('61', '59', 'erwerw1112313', '121111', '3', null, '12.00', null, '2024-12-10 14:34:58', null, null, null, '971da0a062dc47d98ce82bbd208631dc.apk');
INSERT INTO `app_version` VALUES ('64', '86', 'xxx', '23', '3', 'e7c1f8215d5c426db8c0f63712b07c2e.apk', '12.00', null, '2024-12-11 15:33:13', null, null, null, null);
INSERT INTO `app_version` VALUES ('65', '86', '12', '132', '3', '6a4aa0a84c11441f863b19135e5c4621.apk', '121.00', null, '2024-12-12 21:14:01', null, null, null, null);
INSERT INTO `app_version` VALUES ('66', '86', '312', '12321', '3', '2a499935587a4a3ab7bb55e27adfb7b5.apk', '121.00', null, '2024-12-12 21:14:45', null, null, null, null);

-- ----------------------------
-- Table structure for backend_user
-- ----------------------------
DROP TABLE IF EXISTS `backend_user`;
CREATE TABLE `backend_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编码',
  `userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `userType` bigint DEFAULT NULL COMMENT '用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）',
  `createdBy` bigint DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  `userPassword` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of backend_user
-- ----------------------------
INSERT INTO `backend_user` VALUES ('1', 'admin', '系统管理员', '1', '1', '2016-08-20 00:13:41', null, null, '123456');

-- ----------------------------
-- Table structure for data_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `data_dictionary`;
CREATE TABLE `data_dictionary` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `typeCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型编码',
  `typeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型名称',
  `valueId` bigint DEFAULT NULL COMMENT '类型值ID',
  `valueName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型值Name',
  `createdBy` bigint DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  `typeFlag` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of data_dictionary
-- ----------------------------
INSERT INTO `data_dictionary` VALUES ('1', 'USER_TYPE', '用户类型', '1', '超级管理员', '1', '2016-08-12 18:11:47', null, null, 'USER_TYPE_ADMIN');
INSERT INTO `data_dictionary` VALUES ('2', 'USER_TYPE', '用户类型', '2', '财务', '1', '2016-08-12 18:11:47', null, null, '');
INSERT INTO `data_dictionary` VALUES ('3', 'USER_TYPE', '用户类型', '3', '市场', '1', '2016-08-12 18:11:47', null, null, null);
INSERT INTO `data_dictionary` VALUES ('4', 'USER_TYPE', '用户类型', '4', '运营', '1', '2016-08-12 18:11:47', null, null, null);
INSERT INTO `data_dictionary` VALUES ('5', 'USER_TYPE', '用户类型', '5', '销售', '1', '2016-08-12 18:11:47', null, null, null);
INSERT INTO `data_dictionary` VALUES ('6', 'APP_STATUS', 'APP状态', '1', '待审核', '1', '2016-08-12 18:11:47', null, null, 'APP_STATUS_WAIT');
INSERT INTO `data_dictionary` VALUES ('7', 'APP_STATUS', 'APP状态', '2', '审核通过', '1', '2016-08-12 18:11:47', null, null, 'APP_STATUS_YES');
INSERT INTO `data_dictionary` VALUES ('8', 'APP_STATUS', 'APP状态', '3', '审核未通过', '1', '2016-08-12 18:11:47', null, null, 'APP_STATUS_NO');
INSERT INTO `data_dictionary` VALUES ('9', 'APP_STATUS', 'APP状态', '4', '已上架', '1', '2016-08-12 18:11:47', null, null, 'APP_STATUS_ON');
INSERT INTO `data_dictionary` VALUES ('10', 'APP_STATUS', 'APP状态', '5', '已下架', '1', '2016-08-12 18:11:47', null, null, 'APP_STATUS_OFF');
INSERT INTO `data_dictionary` VALUES ('11', 'APP_FLATFORM', '所属平台', '1', '手机', '1', '2016-08-12 18:11:47', null, null, null);
INSERT INTO `data_dictionary` VALUES ('12', 'APP_FLATFORM', '所属平台', '2', '平板', '1', '2016-08-12 18:11:47', null, null, null);
INSERT INTO `data_dictionary` VALUES ('14', 'PUBLISH_STATUS', '发布状态', '1', '不发布', '1', '2016-08-12 18:11:47', null, null, null);
INSERT INTO `data_dictionary` VALUES ('15', 'PUBLISH_STATUS', '发布状态', '2', '已发布', '1', '2016-08-12 18:11:47', null, null, null);
INSERT INTO `data_dictionary` VALUES ('16', 'PUBLISH_STATUS', '发布状态', '3', '预发布', '1', '2016-08-12 18:11:47', null, null, null);
INSERT INTO `data_dictionary` VALUES ('13', 'APP_FLATFORM', '所属平台', '3', '通用', '1', '2016-08-12 18:11:47', null, null, null);

-- ----------------------------
-- Table structure for dev_user
-- ----------------------------
DROP TABLE IF EXISTS `dev_user`;
CREATE TABLE `dev_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `devCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者帐号',
  `devName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者名称',
  `devPassword` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者密码',
  `devEmail` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者电子邮箱',
  `devInfo` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者简介',
  `createdBy` bigint DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of dev_user
-- ----------------------------
INSERT INTO `dev_user` VALUES ('1', 'test001', '测试账户001', '123456', null, null, '1', '2024-08-18 00:13:41', null, null);
INSERT INTO `dev_user` VALUES ('2', 'test2', '测试用户2', '123456', null, null, '1', '2024-11-22 20:49:49', null, null);
```

## 开发
### 整合mybatis
#### 添加依赖
```xml
<dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
    </dependency>
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.2.16</version>
    </dependency> 
    <dependency>
      <groupId>org.mybatis.spring.boot</groupId>
      <artifactId>mybatis-spring-boot-starter</artifactId>
      <version>2.1.2</version>
    </dependency>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
```

#### 配置数据库连接
```yaml
server:
  port: 8888
spring:
  datasource:
    url: jdbc:mysql:///appstudy?serverTimezone=Asia/Shanghai&characterEncoding=utf8
    username: root
    password: 123.com
    type: com.alibaba.druid.pool.DruidDataSource
mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.gxh.app_back.domain
logging:
  level:
    com:
      gxh:
        app_back:
          mapper: debug
```

druid连接池，默认为Hikari

#### idea连接数据库
![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745565883391-b247c6dd-9e92-4e86-aae7-c38bc8a88b8f.png)

驱动选择maven中的jar

#### 用mybatis插件生成实体层和dao层
> 从数据库表逆向生成实体类和mapper
>

安装plugin mybatisx

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745566231346-03654967-17bb-4d27-9739-6ddd172bcd0c.png)

另**easycode**生成代码

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745566448716-4d8b01e9-24dc-4250-aeae-2c2495083743.png)

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745566511380-291b6e81-ae81-4aaa-bfa3-bf8870853016.png)

调整目录

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745567122955-2db58dc2-52c8-4aa5-bf02-0f5bce2843b4.png)

测试

```java
@SpringBootTest
class AppBackApplicationTests {

    @Autowired
    AppCategoryMapper appCategoryMapper;

    @Test
    void contextLoads() {
        AppCategory appCategory = appCategoryMapper.selectByPrimaryKey(2L);
        System.out.println(appCategory);
    }

}
```

pojo:plain old java object 实体层entity/domain

dto:data transfer object 数据传输模型

vo:view object 用于展示的数据

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo {
    private Integer code;// 2000 5000
    private String mess;
    private Object data;// 携带数据

    public static ResultVo success(String mess, Object data) {
        return new ResultVo(2000, mess, data);
    }

    public static ResultVo error(String mess) {
        return new ResultVo(5000, mess, null);
    }

    public static ResultVo reject(String mess) {
        return new ResultVo(3000, mess, null);
    }
}
```

### 查询功能
#### 分页查询和动态查询 find/query
pom.xml

```plain
<!--pagehelper分页插件-->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper-spring-boot-starter</artifactId>
    <version>2.0.0</version>
</dependency>
```

AppInfoMapper.xml

```xml
<select id="selectBy" resultType="com.gxh.app_back.domain.AppInfo">
  select
  <include refid="Base_Column_List" />
  from app_info
  <where>
    <if test="softwarename != null and softwarename != ''">
      softwareName like concat('%', #{softwarename}, '%');
    </if>
    <if test="apkname != null and apkname != ''">
      and apkName like #(apkname);
    </if>
    <if test="status != null">
      and status like #(status);
    </if>
  </where>
</select>
```

apitest

target/apitest.http

```json
### Send POST request with json body
POST http://localhost:8888/appInfo/page?pageNum=2
Content-Type: application/json

{
}

### Send POST request with json body
POST http://localhost:8888/appInfo/page
Content-Type: application/json

{
  "softwarename": "荣耀"
}
```

#### 异常处理
```java
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVo error(Exception e) {
        e.printStackTrace();
        return ResultVo.error(e.getMessage());
    }
}
```

#### vue后台整体布局-登录页和菜单导航主页
![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745765551279-c56ce2af-492f-4b95-96f8-db723d8955c5.png)

CommonView.vue

```vue
<template>
  <el-container style="height: 100vh; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu router
        default-active="/appInfo"
        :default-openeds="['1']">
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-eleme"></i>应用后台</template>
          <el-menu-item-group>
            <el-menu-item index="/appInfo"><i class="el-icon-menu"></i>应用列表</el-menu-item>
            <el-menu-item index="/about"><i class="el-icon-menu"></i>选项2</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>王小虎</span>
      </el-header>

      <el-main>
        <router-view/>
      </el-main>
    </el-container>
  </el-container>
</template>
```

index.js

```javascript
import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginView from "@/views/LoginView.vue";
import AppInfoView from "@/views/AppInfoView.vue";
import CommonView from "@/views/CommonView.vue";
import AboutView from "@/views/AboutView.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginView
  },
  {
    path: '/appInfo',
    name: 'appInfo',
    component: CommonView,
    children: [
      {
        path: '',
        component: AppInfoView
      }
    ]
  },
  {
    path: '/about',
    name: 'about',
    component: CommonView,
    children: [
      {
        path: '',
        component: AboutView,
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
```

### axios请求
#### 配环境
.env.development

```plain
# 开发环境配置
ENV = 'development'
VUE_APP_BASE_API = '/dev-api'
```

.env.production

```plain
# 生产环境配置
ENV = 'production'
VUE_APP_BASE_API = '/prod-api'
```

plugins.axios.js

```javascript
let config = {
  // baseURL: process.env.baseURL || process.env.apiUrl || ""
  // timeout: 60 * 1000, // Timeout
  // withCredentials: true, // Check cross-site Access-Control
  baseURL: process.env.VUE_APP_BASE_API,
};

export {_axios as request};
```

#### cros
vue.config.js

```javascript
module.exports = {
  devServer:{
    host:'localhost',
    port:8088, //前端项目端口号
    open: true,
    proxy:{
      [process.env.VUE_APP_BASE_API]: {
        target: `http://localhost:8888`, //后端项目地址
        changeOrigin: true,
        pathRewrite: {['^' + process.env.VUE_APP_BASE_API]: ''}
      }
    }
  }
}
```

#### 递归实现三级联动
效果图

![画板](https://cdn.nlark.com/yuque/0/2025/jpeg/43817461/1745823985869-b9338b00-97a4-4d4e-af0e-27becfe51bcf.jpeg)

#### 实现新增（无id）和修改（有id）
表单校验

### 图片上传
apipost接口测试

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1745894522985-b3fdfcc3-f856-41af-8553-12a9bcade634.png)

### 图片访问
```vue
 <el-upload
              class="upload-demo"
              name="logo"
              :on-success="uploadSuccess"
              accept="image/*"
              :show-file-list="false"
              :file-list="fileList"
              :action="baseURL + '/appInfo/upLogo/' + scope.row.id"
              multiple
              :limit="1">
            <el-button size="small" type="warning">上传logo</el-button>
</el-upload>
```

```vue
<el-table-column
  label="logo图">
  <template slot-scope="scope">
    <img :src="baseURL +'/'+ scope.row.logopicpath" style="height: 50px; width: 50px">
    </template>
</el-table-column>
```

```javascript
    uploadSuccess(response, file, fileList) {
      console.log(response);
      console.log(file);
      console.log(fileList);
      this.fileList = [];
      this.getPage();
    },
```

baseURL: <font style="color:#bcbec4;background-color:#1e1f22;">process.env.VUE_APP_BASE_API</font>

```javascript
module.exports = {
  devServer:{
    host:'localhost',
    port:8011, //前端项目端口号
    open: true,
    proxy:{
      [process.env.VUE_APP_BASE_API]: {
        target: `http://localhost:8888`, //后端项目地址
        changeOrigin: true,
        pathRewrite: {['^' + process.env.VUE_APP_BASE_API]: ''}
      }
    }
  }
}
```

### app基本信息和版本信息的功能
a.vue -> b.vue 带参数

```vue
this.$router.push({path: "/version", query: {appid: id}});
```

```vue
  created() {
    this.appInfo.id = this.$route.query.appid;
    this.getApp();
  }
```

后端数据

```java
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationdate;
```

#### 添加版本信息
#### 删除appinfo（同时删除logo，版本信息，apk）
拦截器



**事务要同时成功**

<font style="color:#bcbec4;background-color:#1e1f22;">@Transactional(rollbackFor =  Exception.class)</font>

```java
public void del(Long id, String uploadPath) {
        // apk和apkversion

        List<AppVersion> appVersions = appVersionMapper.selectByAppId(id);
        appVersions.forEach(appVersion -> {
            if (appVersion.getDownloadlink() != null) {
                File file = new File(uploadPath + appVersion.getDownloadlink());
                if (file.exists()) {
                    file.delete();
                }
                appVersionMapper.deleteByPrimaryKey(appVersion.getId());
            }
        });

        // 删除appinfo和logo
        AppInfo appInfo = appInfoMapper.selectByPrimaryKey(id);
        if (appInfo.getLogopicpath() != null) {
            File logo = new File(uploadPath + appInfo.getLogopicpath());
            if (logo.exists()) {
                logo.delete();
            }
        }
        appInfoMapper.deleteByPrimaryKey(id);
    }
```

```javascript
    toDel(id) {
      // 防止误操作，添加确认提示
      this.$confirm('此操作将永久删除该app, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {

        delApp(id).then(res => {
          console.log(res);
        });

        this.$message({
          type: 'success',
          message: '删除成功!'
        });
        this.getPage();
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
```

### 登陆注销功能 账号登录验证
#### jwt
json web** token**

**会话存储 token**

```javascript
// 存token
sessionStorage.setItem('token', res.token);
```

### 拦截器（检查回显，上传等）


![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1746068116994-601e8069-ad91-4012-97d4-2576113f8ff0.png)

#### <font style="color:rgb(51, 51, 51);">后端拦截器参考代码</font>
maven search

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1746070356268-92664165-138e-4530-92f4-17f841960ead.png)

fastjson

```java
public class TokenIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        //检查你的token的合法性
        String token = request.getHeader("token");
        Boolean flag = TokenUtils.validateToken(token);

        if(flag){
            return true;
        }else{
            PrintWriter writer = response.getWriter();


            writer.write(JSON.toJSONString(ResultVo.reject("token不合法")));

            writer.close();
            writer.flush();
            return false;
        }
    }
```

<font style="color:rgb(51, 51, 51);">注册拦截器，让拦截器生效</font>

```java
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
        .addPathPatterns("/**") // 添加拦截路径，这里表示拦截所有路径
        .excludePathPatterns("/login", "/resources/**"); // 排除拦截路径，这里表示不拦截登录和静态资源
    }
}
```

<font style="color:rgb(51, 51, 51);">注意上传的图片显示不出来的话，要在拦截器放行</font>

```java
.excludePathPatterns("/**/*.jpg") // 排除.jpg文件
.excludePathPatterns("/**/*.jpeg") // 排除.jpeg文件
.excludePathPatterns("/**/*.png") // 排除.png文件
.excludePathPatterns("/**/*.gif") // 排除.gif文件
.excludePathPatterns("/**/*.bmp") // 排除.bmp文件
.excludePathPatterns("/**/*.webp"); // 排除.webp文件
```

#### <font style="color:rgb(51, 51, 51);">前端请求拦截器</font>
<font style="color:rgb(51, 51, 51);">主要就是让请求头携带 token 令牌</font>

```javascript
_axios.interceptors.request.use(
    function (config) {
        // Do something before request is sent
        // 添加请求头
        var token = sessionStorage.getItem('token');
        if (token) {
            config.headers['token'] = token;
        }
        return config;
    },
    function (error) {
        // Do something with request error
        return Promise.reject(error);
    }
);
```

#### <font style="color:rgb(51, 51, 51);">前端响应拦截器</font>
<font style="color:rgb(51, 51, 51);">主要就是为了，发现 token 有问题的时候直接转发到登录页</font>

<font style="color:rgb(51, 51, 51);">还可以统一处理结果返回，错误提示这些就非常方便了。</font>

```javascript

// Add a response interceptor
_axios.interceptors.response.use(
    function (response) {
        // Do something with response data
        if (response.data.code == 3000) {
            MessageBox.confirm(response.data.mess, "系统提示", {
                    confirmButtonText: '重新登录',
                    cancelButtonText: '取消',
                    type: 'warning'
                }
            ).then(() => {
                location.href = "/";
            })
            // 阻止进一步链式调用 没提示任何信息 不走then
            return new Promise(() => {});


        } else if (response.data.code == 5000) {

            Message.error(response.data.mess);
            return new Promise(() => {});

        } else {
            // 2000 进入 then
            return response.data;
        }
    },
    function (error) {
        // Do something with response error
        return Promise.reject(error);
    }
);

```

### bug图片上传
```vue
<el-upload
  class="upload-demo"
  name="logo"
  :headers="headerObj"
  :before-upload="beforeUpload"
  :on-success="uploadSuccess"
  accept="image/*"
  :show-file-list="false"
  :file-list="fileList"
  :action="baseURL + '/appInfo/upLogo/' + scope.row.id"
  multiple
  :limit="1">

  headerObj: {
        token: sessionStorage.getItem('token'),
      },
```

### 下载链接
```vue
<el-table-column
  label="下载链接">
  <template slot-scope="scope">
    <a :href="'http://localhost:8888/'+scope.row.downloadlink">{{ scope.row.downloadlink }}</a>
  </template>
</el-table-column>
```

### 上架下架功能
![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1746091023905-93fc9f2d-789b-41ae-b28e-4db5afe1f8a0.png)

```plain
<el-dropdown>
  <el-button type="primary">
    更多操作<i class="el-icon-arrow-down el-icon--right"></i>
  </el-button>
  <el-dropdown-menu slot="dropdown">

    <el-dropdown-item
        v-if="scope.row.status==1||scope.row.status==3||scope.row.status==5"
        @click.native="toUpdate(scope.row)">修改
    </el-dropdown-item>

    <el-dropdown-item
        v-if="scope.row.status==1||scope.row.status==3||scope.row.status==5"
        @click.native="toAddVersion(scope.row.id)">添加版本
    </el-dropdown-item>

    <el-dropdown-item
        v-if="scope.row.status==1||scope.row.status==2||scope.row.status==3||scope.row.status==5"
        @click.native="toDel(scope.row.id)">删除
    </el-dropdown-item>

    <el-dropdown-item
        v-if="scope.row.status==2||scope.row.status==5"
        @click.native="upOrDown(scope.row.id)">上架
    </el-dropdown-item>

    <el-dropdown-item
        v-if="scope.row.status==4"
        @click.native="upOrDown(scope.row.id)">下架
    </el-dropdown-item>


  </el-dropdown-menu>
</el-dropdown>
```

```plain
upOrDown(id) {
  onOffApp(id).then((res) =>{
    console.log(res);
    this.getPage();
  })
},
```

```plain
// 上下架
@PutMapping("/upOrDown/{id}")
public ResultVo upOrDown(@PathVariable Long id) {
    AppInfo appInfo = appInfoService.getById(id);
    if(appInfo.getStatus()==4L){
        appInfo.setStatus(5L);
    }
    else if(appInfo.getStatus()==5L){
        appInfo.setStatus(4L);
    }
    appInfoService.saveOrUpdate(appInfo);
    return ResultVo.success("", null);
}
```

### 审核功能 v-if
前端添加显示开发者名称

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1746149312006-2f202f64-f657-4a6d-9563-072596a0d9bd.png)

审核功能不做了

### todo
新增时传入开发者id,新增时可以上传图片

普通用户

管理员管理普通用户和开发者

token中文乱码

## 部署到centos
后端环境：jdk, tomcat

前端环境：nginx

### centos
开启虚拟化

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1746156118670-27745697-a970-4b58-85f9-ad34c30c3499.png)

virtual box

vagrant

[https://developer.hashicorp.com/vagrant/install](https://developer.hashicorp.com/vagrant/install)

```bash
vangrant version
```

```shell
vagrant init centos/7
```

```shell
vagrant up
```

此时virtualbox已有



#### 连接到虚拟机
**不推荐 **新开cmd使用以下连接，速度慢

```shell
vagrant ssh
```



**推荐 **使用xshell

#### 设定虚拟机固定ip
![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1746157937051-918beeba-66f6-4bed-81ad-d853150371e0.png)

vagrant文件

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1746157956450-aa721952-253c-4209-81e3-c33868488b31.png)

默认账号密码：vagrant

重启

```bash
vagrant reload
```

```plain
192.168.56.10
```



#### 设置允许密码登录
使用virtualbox登录，

```bash
vi /etc/ssh/sshd_config
```

PermitRootLogin yes

PasswordAuthentication yes

tip:使用/匹配查找

重启 or

service shh reload

#### linux常用命令
**touch test.txt**

cat test.txt

ps -ef|grep tomcat

kill -9 {PID}

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1746159893871-e909097b-9c7e-49e3-806b-0c91dae1e6df.png)

安装部署环境



**<font style="color:rgba(0, 0, 0, 0.88);">CentOS 7 镜像源失效</font>**<font style="color:rgba(0, 0, 0, 0.88);">是因为该系统已于 </font>**<font style="color:rgba(0, 0, 0, 0.88);">2024 年 6 月 30 日结束生命周期（EOL）</font>**<font style="color:rgba(0, 0, 0, 0.88);">，官方镜像域名 </font>`<font style="color:rgba(0, 0, 0, 0.88);">mirrorlist.centos.org</font>`<font style="color:rgba(0, 0, 0, 0.88);"> 已停止解析。</font>

#### **<font style="color:rgba(0, 0, 0, 0.88);">使用阿里云镜像源</font>**
<font style="color:rgba(0, 0, 0, 0.88);">国内镜像源访问更稳定且持续更新：</font>

```bash
# 进入仓库目录并备份旧配置
cd /etc/yum.repos.d/
sudo mkdir backup && sudo mv CentOS-* backup/

# 下载阿里云配置
sudo curl -O http://mirrors.aliyun.com/repo/Centos-7.repo

# 重建缓存
sudo yum clean all && sudo yum makecache
```



```shell
yum -y install java-1.8.0-openjdk*
```

java -version



tomcat运行

**9.0以上版本不兼容jdk1.8**

<font style="color:rgba(0, 0, 0, 0.88);">版本兼容性参考</font>

| **<font style="color:rgba(0, 0, 0, 0.88);">Tomcat版本</font>** | **<font style="color:rgba(0, 0, 0, 0.88);">最低JDK要求</font>** |
| --- | --- |
| <font style="color:rgba(0, 0, 0, 0.88);">10.1.x</font> | <font style="color:rgba(0, 0, 0, 0.88);">JDK 11+</font> |
| <font style="color:rgba(0, 0, 0, 0.88);">10.0.x</font> | <font style="color:rgba(0, 0, 0, 0.88);">JDK 8+</font> |
| <font style="color:rgba(0, 0, 0, 0.88);">9.x</font> | <font style="color:rgba(0, 0, 0, 0.88);">JDK 8+</font> |
| <font style="color:rgba(0, 0, 0, 0.88);">8.x</font> | <font style="color:rgba(0, 0, 0, 0.88);">JDK 7+</font> |


镜像 [https://mirrors.aliyun.com/apache/tomcat/tomcat-9/v9.0.104/bin/apache-tomcat-9.0.104.tar.gz](https://mirrors.aliyun.com/apache/tomcat/tomcat-9/v9.0.104/bin/apache-tomcat-9.0.104.tar.gz)



download core tar.gz

**tar -zxvf **

cd tomcat/bin/

./startup.sh

查看日志

cd tomcat/log/

**tail -f catalina.out**

[**http://192.168.56.10:8080/**](http://192.168.56.10:8080/)

****

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1746169852375-ca168a3c-8359-4f68-a5b0-389ee1b26607.png)

#### 项目打war包(暂不进行)
### fix war 不含index.jsp
由于视频不含jsp相关内容，部署暂停

[https://blog.csdn.net/weixin_44741023/article/details/119298059](https://blog.csdn.net/weixin_44741023/article/details/119298059)

项目结构，构建

查看进程 ps -ef|grep tomcat

lsof -i :8080

yum install lsof

kill -9 {PID}

rm -rf docs/ examples/

**war包上传tomcat(不是这个目录)，放在webapps自动解压**

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1746173665192-289ff205-d2bd-4ec9-929a-106ac5cda961.png)



#### mysql
[https://mirrors.aliyun.com/mysql/MySQL-8.0/mysql-8.0.27-1.el6.x86_64.rpm-bundle.tar](https://mirrors.aliyun.com/mysql/MySQL-8.0/mysql-8.0.27-1.el6.x86_64.rpm-bundle.tar)

tar -xvf

1. 基础依赖包（需按顺序安装）

rpm -ivh mysql-community-common-8.0.27-1.el6.x86_64.rpm --nodeps --force  
rpm -ivh mysql-community-libs-8.0.27-1.el6.x86_64.rpm --nodeps --force  
rpm -ivh mysql-community-client-plugins-8.0.27-1.el6.x86_64.rpm --nodeps --force  
rpm -ivh mysql-community-libs-compat-8.0.27-1.el6.x86_64.rpm --nodeps --force

2. 客户端与服务端核心包

rpm -ivh mysql-community-client-8.0.27-1.el6.x86_64.rpm --nodeps --force  
rpm -ivh mysql-community-server-8.0.27-1.el6.x86_64.rpm --nodeps --force

3. 可选包（开发工具和测试套件）

rpm -ivh mysql-community-devel-8.0.27-1.el6.x86_64.rpm --nodeps --force  
rpm -ivh mysql-community-test-8.0.27-1.el6.x86_64.rpm --nodeps --force



启动

mysqld --initialize

安装，自启动，修改默认密码

设置远程登录账号，navicat连接，转储sql，服务器创建数据库，运行sql

**remote_user 123.com**

测试登陆接口

### 前端部署nginx
正向代理

反向代理

yum install -y pcre-devel

yum -y install make zlib zlib-devel gcc-c++ libtool openssl openssl-devel

nginx.org安装nginx

./configure

make && make install

cd /usr/local/nginx/

./sbin/nginx 

[http://192.168.56.10/](http://192.168.56.10/) 默认80

#### 前端打包
npm run build

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1746181604876-820cabef-71f2-44f8-b319-452ca7f1dffe.png)

dist目录上传

![](https://cdn.nlark.com/yuque/0/2025/png/43817461/1746181708786-0ab07e14-eafe-496f-9605-ddd994ecf70c.png)

[http://192.168.56.10/](http://192.168.56.10/)

nginx反向代理

```plain
  location /prod-api {
            proxy_pass http://localhost:8080/
  }
```

     

重启

[root@vbox sbin]# ./nginx -s reload

## 部署到render
[https://dashboard.render.com/](https://dashboard.render.com/)

[https://juejin.cn/post/7261599630827683896](https://juejin.cn/post/7261599630827683896)



