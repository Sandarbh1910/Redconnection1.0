<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Red Connection</title>
  <link rel="stylesheet" href="CSS/index.css">
</head>

<body>

  <header>
    <a href="#home" class="logo"> <img src="Icons/red chain img.png" alt="">
      Red Connection</a>
    <div class="links">
      <a href="#home" class="home">Home</a>
      <a href="#about-us-page" class="about-us">About Us</a>
      <a href="#contact-us-page" class="contact-us">Contact Us</a>
    </div>
  </header>


  <main id="home">



    <div class="landing-page">
      <div class="landing-intro">
        <h3 class="greeting"> Hi,Saviour</h3>
        <div class="intro-animation">
          <h3 class="landing-page-title"> DONATE BLOOD</h3>
          <ul class="dynamic-txt">
            <li>Save lives</li>
            <li>Get rewarded.</li>
          </ul>
        </div>

        <button class="signup-btn" onclick="location.href='signup.jsp'">Sign Up</button>


      </div>
      <img class="landing-svg" src="Img/Blood donation.svg" alt="">
      <h5 class="landing-page-msg">Your droplets of blood may create an
        ocean of happiness.</h5>
    </div>

<div id="steps">
  <h1>Steps</h1>
  <div class="step-container">
    <img src="Img/signup.svg" alt="">
    <div class="step">1)Sign UP</div>
  </div>
  <div class="step-container">
    <div class="step">2)Login</div>
    <img src="Img/login.svg" alt="">
  </div>
  <div class="step-container">
    <img src="Img/donate.svg" alt="">
    <div class="step">3)Donate</div>
  </div>
  <div class="step-container">
    <div class="step">4)Get Certificates and Rewards </div>
    <img src="Img/certificate.svg" alt="">
  </div>

</div>

    <div id="about-us-page">
      <h1>About Us</h1>
      <p>
        Suppose you are at the hospital with your near and dear one for some kind of medical treatment ,might be a small
        surgery but all of a sudden with the change of events the situation becomes critical and the medical staff
        rushes to you and tells you that there is an urgent  requirement for blood and asks you to arrange some units of blood
        as the institute is out of stock with the desired blood group .You inquired about it among your relatives and
        nearby blood banks but
        group doesn't match or somehow the other banks are too out of stock . Now what will you do ? </p>

      <h4>Isn't it sounds terrifying?</h4>

      <p>Now suppose you (like most of the people at present due to awareness) are willing to help people in such
        unexpected crisis . But without been knowing who requires and where , how can you/anyone help someone ?</p>


      <h3>Now what to do ? We have both seekers and donors but are unaware of each others requirements and intentions.
      </h3>

      <p> We at Red Connection try to solve this practical problem by bridging the gap between them.We pass the
        request of a seeker to corresponding
        donors with real-time mailing service without compromising the donors and seekers privacy.Along with it we verify
        the donor at the institute where donation is to be done and reward the donors for their noble deed (not
        monetarily instead by providing them with certificates of appreciation and suitable medical service thereby
        contributing in the healthy nation mission.)</p>
      <h2>Now it sounds cool 😎. Good deed + reward + medical care = awesome🤟.
      </h2>

    </div>

    <div id="contact-us-page">
      <h1 class="page-title">Contact Us</h1>
      <form class="contactus-form" action="RCContactServlet" method="POST">
        <input type="text" class="input-data" placeholder="Name" name="cname" required>
        <input type="tel" class="input-data" placeholder="Mobile" name="cmob" required>
        <input type="email" class="input-data" placeholder="Email" name="cemail" required >
        <select  name="reason" class="input-data">
            <option value="Suggestion">Suggestion</option>
            <option value="Problem">Problem</option>
        </select>
        <textarea name="msg" id="" cols="30" rows="10" class="input-data" required placeholder="Type here"></textarea>
        <input type="submit" value="Send" class="contactus-submit-btn">
      </form>

      <iframe class="ourmap"
        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3665.787087336097!2d77.52153716477392!3d23.250833634837957!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x397c4244c97d6f29%3A0x72457a4e85fd116c!2sLNCT%20Group%20of%20Colleges!5e0!3m2!1sen!2sin!4v1649514280944!5m2!1sen!2sin"
        style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>

      <a class="contact-details" href="tel:+917470515628">+917470515628</a>

      <a class="contact-details" href="mailto:sandarbh19o@gmail.com">sandarbh19o@gmail.com</a>
    </div>



    <footer>
      <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div>
    </footer>
  </main>

</body>

</html>