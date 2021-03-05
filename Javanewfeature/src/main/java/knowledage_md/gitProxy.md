git 设置和取消代理

	git config --global https.proxy http://127.0.0.1:1080
	
	git config --global https.proxy https://127.0.0.1:1080
	
	git config --global --unset http.proxy
	
	git config --global --unset https.proxy
	
	
	npm config delete proxy
	
	
socks5
	
	git config --global http.proxy 'socks5://127.0.0.1:1080'
	git config --global https.proxy 'socks5://127.0.0.1:1080'
	
	
#只对github.com
	git config --global http.https://github.com.proxy socks5://127.0.0.1:1080

#取消代理
	git config --global --unset http.https://github.com.proxy)



https访问
仅为github.com设置socks5代理(推荐这种方式, 公司内网就不用设代理了, 多此一举):
git config --global http.https://github.com.proxy socks5://127.0.0.1:1086
其中1086是socks5的监听端口, 这个可以配置的, 每个人不同, 在macOS上一般为1086.
设置完成后, ~/.gitconfig文件中会增加以下条目:

	[http "https://github.com"]
	    proxy = socks5://127.0.0.1:1086
ssh访问
需要修改~/.ssh/config文件, 没有的话新建一个. 同样仅为github.com设置代理:

	Host github.com
	    User git
	    ProxyCommand nc -v -x 127.0.0.1:1086 %h %p
如果是在Windows下, 则需要个性%home%.ssh\config, 其中内容类似于:

	Host github.com
	    User git
	    ProxyCommand connect -S 127.0.0.1:1086 %h %p
这里-S表示使用socks5代理, 如果是http代理则为-H. connect工具git自带, 在<Git>\mingw64\bin\下面.


## shadowsocks

设置代理

	git config --global http.proxy socks5h://127.0.0.1:1080
取消代理

	git config --global --unset http.proxy
因为我用的是shadowsocks代理，所以上面是socks5h://, 如果用的是http代理，将socks5h改为http即可

如果仅仅想为github设置代理，可以这样：

	git config --global http.https://github.com.proxy socks5h://127.0.0.1:1080


## windows 10

操作系统是 win 10，代理用 SSR，端口 1080。
先设置了

git config --global http.https://github.com.proxy socks5h://127.0.0.1:1080
接着用

git config --global --get http.https://github.com.proxy
得到反馈

socks5h://127.0.0.1:1080
说明设置成功。
下面在用户文件夹的 .ssh 中建立 config 文件，内容为

	ProxyCommand connect -S 127.0.0.1:1080 -a none %h %p
	
	Host github.com
	  User git
	  Port 22
	  Hostname github.com
	  IdentityFile "C:\Users\****\.ssh\id_rsa"
	  TCPKeepAlive yes
	  ServerAliveInterval 600
	  IPQoS=throughput
	  ServerAliveCountMax 120
	
	Host ssh.github.com
	  User git
	  Port 443
	  Hostname ssh.github.com
	  IdentityFile "C:\Users\****\.ssh\id_rsa"
	  TCPKeepAlive yes
	  ServerAliveInterval 600
	  IPQoS=throughput
	  ServerAliveCountMax 120
	注意****要换成用户自己的名称。


## vray

git最近更新了socks5的语法，去掉了引号，

   git config --global http.proxy socks5://127.0.0.1:10808
   
配合V2RayN可用
80是代理服务器开放端口；10808是v2ray本地监听端口，所有git设置这个监听端口；


## 参考

http://www.mikeheijmans.com/sysadmin/2014/08/12/proxy-ssh-over-socks/

https://segmentfault.com/q/1010000000118837	

https://stackoverflow.com/questions/15227130/using-a-socks-proxy-with-git-for-the-http-transport