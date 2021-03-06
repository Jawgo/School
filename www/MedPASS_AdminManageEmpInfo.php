<?php

// Initialize the session
session_start();
 
// If session variable is not set it will redirect to login page
if(!isset($_SESSION['username']) || empty($_SESSION['username'])){
  header("location: MedPASS_Welcome.php");
  exit;
}
?>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>MedPASS</title>
  <link rel="stylesheet" href="AdminFormat.css">
</head>

<body>
  <div class="wrapper">
    <header>
      <nav>
        <div class="logo">
          <h2>Med<span class="highlight">PASS</span></h2>
        </div>
        <div class="menu">
          <ul>
            <li><a href="MedPASS_AdminHome.php">Home</a></li>
			<li><a href="MedPASS_AdminViewEmpInfo.php">Back</a></li>
			<li><a href="MedPASS_Welcome.php">Logout</a></li>
          </ul>
        </div>
      </nav>
    </header>

    <section id="showcase">
      <div class="patientSubPage">
        <h1>Manage Employee Information</h1>
      </div>
    </section>
  </div>

  <section id"content">
    <div class="container contentSubPage">
      <p>
      
      <!DATABASE TODO>
      
      Employee ID:   <br>
	  First Name:   <br>
	  Last Name:   <br>
	  Address:     <br>
	  Phone Number:    <br>
	  Email:    <br>
      Specialization or Position: <span style="padding: 0 40px">&nbsp;</span>    <br>
      <br> <br>
      
      <a href="MedPASS_AdminEditEmpInfo.php"><input type="submit" value="Edit Employee Info"></a> 
      <br>
      <form  method="POST" action="MedPASS_AdminViewEmpInfo.php"> <!DATABASE TODO>
      <a href="MedPASS_AdminViewEmpInfo.php"><input type="submit" value="Delete Employee"></a>
      </form>
      </p>

    </div>
  </section>
  
  
  <footer>
    <p>The MedPASS Organization, Copyright &copy; 2018</p>
  </footer>

</body>

</html>
