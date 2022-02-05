echo "---------------------Build started-----------------------"

# Проверка (сам код берем с github)

ls -la
cat index.html
echo "Build by Jenkins №: $BUILD_NUMBER" >> index.html
cat index.html

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
