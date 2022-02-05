echo "---------------------Build started-----------------------"
cat <<EOF >index.html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>DeployTestSite</title>
  </head>
  <body bgcolor="black">
    <center>
      <h2><font color="yellow">Hello from Maxim</font></h2>
      <a href="https://github.com/mylitvinov">
        <font color="green">Профиль GitHub</font>
      </a>
    </center>
  </body>
</html>
EOF
echo "---------------------Build finished----------------------"

echo "---------------------Test started-----------------------"
result=$(grep "Hello" index.html | wc -l)
echo $result
if [ $result = '1' ]; then
  echo "Test Passed"
  # exit 0
else
  echo "Test Failed"
  exit 1
fi
echo "---------------------Test finished----------------------"

echo "-----------------Deployment started-----------------------"

scp index.html root@ub1:/var/www/html

echo "-----------------Deployment finished----------------------"

# Для плагина Publisher over SSH
# ssh-keygen -t rsa -b 4096 -m PEM
# не опен OPENSSH ключ
