# Heroku CLI Deployment

## Step
* create git repository for the application at local environment 
* download Heroku CLI
* input `heroku login` on terminal to login heroku
* go to source code direction on terminal, input `heroku create`, then it will auto create remote heroku git repository and add remote heroku git repository to local git repository.
* input `git push heroku master` on terminal, then it will push local code to heroku, and will auto deploy application to Heroku.

## The appendix
visit [heroku dev center](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku) to see the details.