

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]









<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
   <p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/NASA_logo.svg/2449px-NASA_logo.svg.png" width="120" height="100" text-align="center"/>
</p>
  </a>

  <h3 align="center">NasaDataApi</h3>

  <p align="center">
   This is a project with the Nasa API to get a list of Asteroids with some values getting by response from the JSON file of the API. 
    <br />
        <br />
    <a href="https://ssd-api.jpl.nasa.gov/doc/index.php"><strong>Explore the docs »</strong></a>
    <br />
    <br />
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This project is a microservice developed in Java using Spring Boot framework that connects to NASA's API to search for near-Earth asteroids and retrieves the most dangerous ones based on their properties. The microservice has been designed to provide efficient and fast results to other applications that require this information.

<h2>Features</h2>
<ul>
	<li>Retrieves data from NASA's API on near-Earth asteroids</li>
	<li>Filters and sorts asteroid data based on their properties</li>
	<li>Returns the most dangerous asteroids in terms of potential impact and close approach</li>
	<li>Built using Spring Boot and Java to ensure high performance and reliability</li>
	<li>Includes unit tests using Mockito and JUnit to ensure code quality and functionality</li>
</ul>

<p>This microservice is ideal for developers who need a reliable and efficient way to retrieve information on near-Earth asteroids. It provides a simple and easy-to-use API that can be integrated with any application that requires asteroid data. The use of Spring Boot and Java ensures that the microservice is scalable and can handle high volumes of requests.</p>

<h2>Conclusion</h2>
<p>The NASA Near-Earth Asteroids Microservice is a powerful tool for developers who need to retrieve information on near-Earth asteroids quickly and efficiently. Its use of Spring Boot and Java ensures high performance and reliability, and its simple API makes it easy to integrate with other applications. The unit tests using Mockito and JUnit ensure that the microservice is functional and reliable.</p>


<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

This section should list any major frameworks/libraries used to bootstrap your project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

[![Java][java-shield]][java-url] [![Spring Boot][springboot-shield]][springboot-url] [![Mockito][mockito-shield]][mockito-url] [![JUnit][junit-shield]][junit-url] [![Maven][maven-shield]][maven-url]




<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Get a free API Key at [https://api.nasa.gov/](https://api.nasa.gov/)
2. Clone the repo
   ```sh
    git clone https://github.com/Ajgarcia01/NasaDataApi.git
   ```
3. Started all maven dependencies

4. Enter your API in `url3`
   ```java
   private final String url3="&api_key=YOUR_API_KEY";
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

To use this project, you can send a GET request to the following endpoint:

   ```sh
   http://localhost:8080/asteroids?days={number_of_days}
   ```

<ul>
  <li>This will return a JSON objects containing data on the most dangerous asteroids based on their properties, as determined by NASA's Near Earth Object Web Service, within the specified number of days from today.</li>
      <br />
  <li>By default, the endpoint only returns data on asteroids with hazardous set to true.</li>
      <br />
  <li>Also this asteroids have a properties in JSON response:</li>
      <br />
  <ul>
    <li>limit: The maximum number of results to return (default: 3)</li>
    <li>order: The order in which to sort the results (default: asc)</li>
  </ul>
      <br />
  <li>The search will be the 3 most dangerous asteroids in the next 7 days in ascending order</li>
</ul>

_For more examples, please refer to the [Documentation](https://api.nasa.gov/)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the Apache License 2.0. See `LICENSE` for more information.

_For more information, please refer to the [LICENSE](https://www.apache.org/licenses/LICENSE-2.0)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

* [![LinkedIn][linkedin-shield]][linkedin-url]
* [![GitHub][github-shield]][github-url]
* [![Personal Website][website-shield]][website-url]
* [![Email][email-shield]][email-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

We would like to express our gratitude to all contributors and open source projects that have made this project possible. We also want to thank NASA for providing the Near Earth Object Web Service and the information necessary to create this microservice.

* [Choose an Open Source License Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)
* [Nasa API](https://api.nasa.gov/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/Ajgarcia01/NasaDataApi/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/Ajgarcia01/NasaDataApi/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/Ajgarcia01/NasaDataApi/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/Ajgarcia01/NasaDataApi/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/Ajgarcia01/NasaDataApi/blob/main/LICENSE
[java-shield]: https://img.shields.io/badge/-Java-orange?logo=java&logoColor=white&style=for-the-badge
[java-url]: https://www.java.com/
[springboot-shield]: https://img.shields.io/badge/-Spring%20Boot-brightgreen?logo=spring&logoColor=white&style=for-the-badge
[springboot-url]: https://spring.io/projects/spring-boot
[mockito-shield]: https://img.shields.io/badge/-Mockito-red?logo=mockito&logoColor=white&style=for-the-badge
[mockito-url]: https://site.mockito.org/
[junit-shield]: https://img.shields.io/badge/-JUnit-blue?logo=junit&logoColor=white&style=for-the-badge
[junit-url]: https://junit.org/
[maven-shield]: https://img.shields.io/badge/-Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white
[maven-url]: https://maven.apache.org/
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-blue?style=for-the-badge&logo=linkedin&logoColor=white
[linkedin-url]: https://www.linkedin.com/in/jgl11/
[github-shield]: https://img.shields.io/badge/-GitHub-black?style=for-the-badge&logo=github&logoColor=white
[github-url]: https://github.com/Ajgarcia01/
[website-shield]: https://img.shields.io/badge/-Personal%20Website-green?style=for-the-badge&logo=google-chrome&logoColor=white
[website-url]: https://ajgarcia01.github.io/
[email-shield]: https://img.shields.io/badge/-Email-red?style=for-the-badge&logo=mail.ru&logoColor=white
[email-url]: mailto:jesusgarcialuque11@gmail.com
