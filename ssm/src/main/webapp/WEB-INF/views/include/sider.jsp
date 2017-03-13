<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- Left side column. contains the sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">

            <li class="header">业务模块</li>
            <shiro:hasRole name="role_sales">
            <li class="treeview ${param.menu == 'business_device_rent' ? 'active' : ''}">
                <a href="/device/rent">
                    <i class="fa fa-circle-o"></i> <span>设备租赁</span>
                </a>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-circle-o"></i> <span>劳务派遣</span>
                </a>
            </li>
            </shiro:hasRole>
            <li class="treeview ${param.menu == 'pan' ? 'active' : ''}" >
                <a href="/pan">
                    <i class="fa fa-circle-o"></i> <span>网盘系统</span>
                </a>
            </li>

            <shiro:hasRole name="role_fin">
                <li class="header">财务模块</li>
                <li class="treeview ${fn:startsWith(param.menu,"fin_") ? 'active' : ''}">
                    <a href="#">
                        <i class="fa fa-bar-chart"></i> <span>财务报表</span> <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li class="${param.menu == 'fin_day' ? 'active' : ''}">
                            <a href="/finance/day"><i class="fa fa-circle-o"></i> 财务日报</a>
                        </li>
                        <li class="${param.menu == 'fin_month' ? 'active' : ''}">
                            <a href="/finance/month"><i class="fa fa-circle-o"></i> 财务月报</a>
                        </li>
                        <li class="${param.menu == 'fin_year' ? 'active' : ''}">
                            <a href="/finance/year"><i class="fa fa-circle-o"></i> 财务年报</a>
                        </li>
                    </ul>
                </li>
            </shiro:hasRole>
            <li class="header">工作流模块</li>
            <li class="treeview ${fn:startsWith(param.menu,"pro") ? 'active' : ''}">
                <a href="#">
                    <i class="fa fa-bar-chart"></i> <span> 个人流程</span> <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li class="${param.menu == 'pro_apply' ? 'active' : ''}">
                        <a href="/process"><i class="fa fa-circle-o"></i> 发起流程</a>
                    </li>
                    <li class="${param.menu == 'pro_apply' ? 'active' : ''}">
                        <a href="/process"><i class="fa fa-circle-o"></i> 我的代办</a>
                    </li>

                </ul>
            </li>
            <shiro:hasRole name="role_admin">
                <li class="header">设置模块</li>
                <li class="treeview ${fn:startsWith(param.menu,'sys_') ? 'active' : ''}">
                    <a href="#">
                        <i class="fa fa-cogs"></i> <span>系统设置</span> <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li class="${param.menu == 'sys_accounts' ? 'active' : ''}">
                            <a href="/user"><i class="fa fa-circle-o"></i> 账户管理</a>
                        </li>
                        <li class="${param.menu == 'sys_device' ? 'active' : ''}">
                            <a href="/setting/device"><i class="fa fa-circle-o"></i> 设备管理</a>
                        </li>
                    </ul>
                </li>
            </shiro:hasRole>
            <li class="header">用户模块</li>
            <li class="treeview">
                <a href="/logout">
                    <i class="fa fa-sign-out"></i> <span>安全退出</span></i>
                </a>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
