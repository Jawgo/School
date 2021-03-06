<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>MedPASS</title>
  <link rel="stylesheet" href="DoctorFormat.css">
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
            <li><a href="MedPASS_DoctorHome.php">Home</a></li>
			<li><a href="MedPASS_DoctorViewPatientInfo.php">Back</a></li>
			<li><a href="MedPASS_Welcome.php">Logout</a></li>
          </ul>
        </div>
      </nav>
    </header>

    <section id="showcase">
      <div class="patientSubPage">
        <h1>Add a New Illness</h1>
      </div>
    </section>
  </div>

  <section id"content">
    <div class="container contentSubPage">
      <p>
      <form  method="POST" action="MedPASS_DoctorViewPatientInfo.php"> <!DATABASE TODO>
		<label for="ill">Illness Name:</label><br>
		<input type="text" id="ill" name="illness" placeholder="Illness...">
		<br>
		<label for="ill">Causes:</label><br>
		<textarea name="textarea" maxlength = "255" cols="85" rows="3" id="cause" name="causes" placeholder="Causes..."></textarea>
		<br>
		<label for="ill">Symptoms:</label><br>
		<textarea name="textarea" maxlength = "255" cols="85" rows="3" id="sympt" name="symptoms" placeholder="Symptoms..."></textarea>
		<br>
	  <a href="MedPASS_DoctorViewPatientInfo.php"><input type="submit" value="Add New Illness"></a>
      </form>
	</p>
    </div>
  </section>
  
  <footer>
    <p>The MedPASS Organization, Copyright &copy; 2018</p>
  </footer>

</body>

</html>
