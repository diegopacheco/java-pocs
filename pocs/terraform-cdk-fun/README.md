### Install
```bash
npm install -g cdktf-cli
```
### Run 
cdktf.json more on https://github.com/diegopacheco/java-pocs/tree/master/pocs/terraform-cdk-fun
```json
{
  "language": "java",
  "app": "mvn -e -q compile exec:java",
  "terraformProviders": [
    "kubernetes@~> 1.11.3"
  ]
}
```
```bash
cdktf get
cdktf synth
cdktf deploy
```

more on https://gist.github.com/diegopacheco/0a3ecc594112e316578457c77ed91a4d/edit
