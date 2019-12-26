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
  comment '灯谜表，存放输入的灯谜';

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

create table myty_param
(
  param_id    varchar(20)  not null
  comment '参数名称',
  param_value varchar(100) not null
  comment '参数值',
  param_desc  varchar(50)  null
  comment '参数描述'
)
  comment '参数表';

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

