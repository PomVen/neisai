create table myty_agenda
(
  round_no    int      not null
  comment '轮次',
  start_time  datetime not null
  comment '开始时间',
  do_time     datetime not null
  comment '猜射时间',
  judge_time  datetime not null
  comment '评分列中时间',
  end_time    datetime not null
  comment '结束时间',
  input_count int      not null
  comment '输入条数'
)
  comment '日程安排表';

create table myty_answer
(
  agenda_round_no int          not null
  comment '轮次',
  dm_id           int          not null
  comment '灯谜ID',
  user_id         varchar(20)  not null
  comment '用户ID',
  user_answer     varchar(200) null
  comment '用户的谜底',
  user_judge      int          null
  comment '用户的评分',
  is_right        int          null
  comment '是否正确：1-正确；2-不正确；3-列中'
)
  comment '记录用户的答案和评分';

create table myty_dengmi_temp
(
  agenda_round_no int           not null
  comment '轮次',
  dm_mimian       varchar(2000) null
  comment '谜面',
  dm_mimu         varchar(200)  null
  comment '谜目',
  dm_midi         varchar(500)  null
  comment '谜底',
  dm_mimianzhu    varchar(500)  null
  comment '谜面注解',
  dm_midizhu      varchar(500)  null
  comment '谜底注解',
  dm_author       varchar(20)   null
  comment '灯谜作者，存用户ID',
  dm_temp_id      int           not null
  comment '临时ID',
  constraint myty_dengmi_temp_dm_temp_id_uindex
  unique (dm_temp_id)
)
  comment '灯谜临时表，存放当前轮的灯谜输入';

alter table myty_dengmi_temp
  add primary key (dm_temp_id);

create table myty_log
(
  oper_time       datetime    null
  comment '操作时间',
  oper_desc       varchar(20) null
  comment '操作',
  agenda_round_no int         null
  comment '轮次'
)
  comment '日志事件表；用于记录计分是否完成';

create table myty_menu
(
  menu_id      varchar(20)  not null
  comment '菜单ID',
  menu_name    varchar(20)  not null
  comment '菜单名称',
  menu_path    varchar(100) not null
  comment '菜单指向路径',
  menu_role    varchar(20)  not null
  comment '菜单权限',
  menu_type    int          not null
  comment '类型：1-功能菜单；2-友情链接',
  parent_menu  varchar(20)  null
  comment '父级菜单',
  has_children int          null
  comment '是否含有子菜单：0-否；1-是',
  menu_order   varchar(4)   null
  comment '菜单出现的时间：0000-一直出现；第一位是1-输入谜题阶段；第二位是1-输入猜射阶段；第三位是1-评分列中阶段；第四位是1-结束之后'
);

create table myty_role
(
  role_id   varchar(20) not null
  comment '角色ID',
  role_name varchar(20) not null
  comment '角色名',
  constraint myty_role_role_id_uindex
  unique (role_id)
)
  comment '角色表';

alter table myty_role
  add primary key (role_id);

create table myty_role_rel
(
  user_id varchar(20) null
  comment '用户ID',
  role_id varchar(20) null
  comment '角色ID'
)
  comment '角色与用户的映射表';

create table myty_score
(
  agenda_round_no int             not null
  comment '轮次',
  user_id         varchar(20)     not null
  comment '参赛人ID',
  user_score      int             null
  comment '得分,暂不使用该字段',
  score_type      varchar(1)      not null
  comment '得分类型：1-猜射得分；2-制谜得分；暂不使用该字段',
  user_ans_score  int default '0' null
  comment '用户猜射得分',
  user_sub_score  int default '0' null
  comment '用户制谜得分'
)
  comment '得分表';

create table myty_seq
(
  seq_name varchar(20) not null
  comment 'ID类型
',
  next_id  int         not null
  comment '下一个ID号'
)
  comment 'ID生成表';

create table myty_user
(
  user_id       varchar(20)     not null
  comment '用户ID',
  user_name     varchar(45)     not null
  comment '用户名称',
  user_role     varchar(45)     not null
  comment '用户角色：1-普通用户；0-管理员',
  user_password varchar(45)     not null
  comment '用户密码',
  is_developer  int default '0' null
  comment '是否开发者：0-否；1-是',
  constraint user_id_UNIQUE
  unique (user_id)
)
  comment '用户表';

alter table myty_user
  add primary key (user_id);

insert into myty_user (user_id, user_name, user_role, user_password, is_developer) values ('MYTY_001','root','0','123456',0);

insert into myty_seq (seq_name, next_id) values ('user_id',2),('dengmi_temp_id',1),('agenda_round_no',1),('menu_id',26);

INSERT INTO miyuantianya.myty_role (role_id, role_name) VALUES ('0', '普通用户');
INSERT INTO miyuantianya.myty_role (role_id, role_name) VALUES ('1', '管理员');
INSERT INTO miyuantianya.myty_role (role_id, role_name) VALUES ('2', '开发者');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_001', '输入猜射', '/page/toInputAnswer', '0', 1, '0', 0, '0010');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_002', '输入谜题', '/page/toInputMySubject', '0', 1, '0', 0, '0001');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_003', '评分', '/page/toPingfen', '0', 1, '0', 0, '0100');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_004', '列中', '/page/toLiezhong', '0', 1, '0', 0, '0100');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_005', '当前赛况', '/page/toSaikuang', '0', 1, '0', 0, '0111');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_006', '我的谜题', '/page/toMySubject', '0', 1, '0', 0, '0110');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_007', '查看结果', '', '0', 1, '0', 1, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_008', '查看日程', '/login/agendaDetail', '0', 1, '0', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_009', '修改密码', '/page/toChangePassword', '0', 1, '0', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_010', '新增用户', '/page/toAddUser', '1', 1, '0', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_011', '发起比赛', '/page/toNewAgenda', '1', 1, '0', 0, '1000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_012', '游子吟论坛（华清官网）', 'http://www.youziyin.com/bbs/index.asp', '0', 2, '0', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_013', '国粹网', 'http://www.zhgc.com/index.asp', '0', 2, '0', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_014', '谜材网', 'http://www.chundeng.com/micai/', '0', 2, '0', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_015', '天涯社区灯谜论坛', 'http://bbs.tianya.cn/list.jsp?item=66&sub=1', '0', 2, '0', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_016', '用户管理', '/page/userManage', '1', 1, '0', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_017', '菜单管理', '/page/menuManage', '1', 1, '0', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_018', '本轮得分榜', '/page/toThisScore', '0', 1, 'menu_007', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_019', '总积分榜', '/page/toHisScore', '0', 1, 'menu_007', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_020', '猜射成绩榜', '/page/toAnswerScore', '0', 1, 'menu_007', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_021', '制谜成绩榜', '/page/toSubjectScore', '0', 1, 'menu_007', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_022', '佳谜榜', '/page/toGoodSubject', '0', 1, 'menu_007', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_023', '全部谜题', '/page/toAllSubject', '0', 1, 'menu_007', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_024', '系统开发', '/page/toDevelopDetail', '2', 3, '0', 0, '0000');
INSERT INTO miyuantianya.myty_menu (menu_id, menu_name, menu_path, menu_role, menu_type, parent_menu, has_children, menu_order) VALUES ('menu_025', '新增友情链接', '/page/toAddMenu', '1', 1, '0', 0, '0000');
