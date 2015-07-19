<div id="wrapper">

	 <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

		<!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="home">Achievement Hunter</a>
        </div>

        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
			<li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                	<i class="fa fa-user"></i> 
                	Dionatan Ribeiro 
                	<b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="#">
                        	<i class="fa fa-fw fa-user"></i> 
                        	Perfil
                        </a>
                    </li>
                    <li>
                        <a href="#">
                        	<i class="fa fa-fw fa-gear"></i> 
                        	Configuracoes
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                        	<i class="fa fa-fw fa-power-off"></i> 
                        	Log Out
                        </a>
                    </li>
                </ul>
            </li>
        </ul>

		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
				<li style="padding: 10px"></li>
				<li class="col-sm-12">
                    <div class="row">
                        <div class="col-lg-6">
	                        <a href="#" class="circle">
								<img height="64" width="64" 
								src="http://static.giantbomb.com/uploads/scale_small/0/2241/663872-vault_boy_manip.jpg" alt="Usuario">
							</a>
                        </div>
                        <div class="col-lg-6" style="padding: 5px">
	                        <h3 style="color: white">
	                        	Seigen
	                        </h3>
                        </div>
                    </div>
				</li>
				<li style="padding: 10px"></li>
                <li class="active">
                    <a href="index.html">
                    	<i class="fa fa-fw fa-dashboard"></i> 
                    	Perfil
                    </a>
                </li>
                <li>
                    <a href="charts.html">
                    	<i class="fa fa-fw fa-bar-chart-o"></i>
                    	Ranking
                    </a>
                </li>
                <li>
                    <a href="tables.html">
                    	<i class="fa fa-fw fa-table"></i>
                    	Mural de Conquistas
                    </a>
                </li>
            </ul>
        </div>
		<!-- /.navbar-collapse -->

    </nav>

	<div id="page-wrapper">
		<div class="container-fluid">
			<jsp:include page="steam/home.jsp" />
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->