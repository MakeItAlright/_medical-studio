 updateWorkersByUsername、updateWorkersByUsername、register等接口传入的是自定义的
 对象类型，需要严格按照数据库对应的字段post数据,post示例(json解析不一定管用，form发送测试成功
******
```
 <script>
  export default {
    methods: {
     submitForm(login) {
         this.$refs[login].validate((valid) => {
             if (valid) {
               //提交表单
               this.$http.post('http://127.0.0.1:8080/user/login', {
                 username: this.login.username,
                 password: this.login.password
                 }).then(result => {
                     console.log(result);
                     if (result.bodyText === 'home') {
                         this.$router.push({ path: 'home' }); //跳转到home组件中
                     } else {
                       console.log("登录失败");
                       return false;
                     }
                   });
             } else {
               console.log('error submit!!');
               return false;
             }
           });
       }
   }
 }
 </script>
```
