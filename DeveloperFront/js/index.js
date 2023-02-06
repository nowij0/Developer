$(()=>{
    checkIntervalLogined();
    let queryStr = location.search.substring(1) // ?뒤에 붙는 매개변수 값 반환 
    let arr = queryStr.split('=')
    if(arr[0] == 'menu'){
     console.log('메뉴', arr[1])
         switch(arr[1]){
         case 'lesson':
             $('header>nav>ul>li.lesson').click()
             break;
         case 'studycafe':
             $('header>nav>ul>li.studycafe').click()
             location.href='./studycafeList.html'
             break;
         case 'community':
             $('header>nav>ul>li.community').click()
             break;
         case 'signup':
             $('header>nav>ul>li.signup').click()
             break;
         case 'login':
             $('header>nav>ul>li.login').click()
             break;     
         case 'logout':
             $('header>nav>ul>li.logout').click()
             break;      
         case 'tutorAdd':
             $('header>nav>ul>li.tutorAdd').click()
             break;      
         case 'myPage':
             $('header>nav>ul>li.myPage').click()
             break;      
         }
    }
 })