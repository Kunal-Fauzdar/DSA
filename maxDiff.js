var minMaxDifference = function(num) {
    let maxNum = num;
    let minNum = num;
    let temp=num;
    let max=0;
    let min=0;
    let count=0;
    while(num>0){
        let remainder = num%10;
        num = Math.floor(num / 10);
        if(remainder!=9){
            max=remainder;
        }
        if(remainder!=0){
            min=remainder;
        }
    }
     
    while(temp>0){
        let remainder = temp%10;
        if(remainder==max){
            maxNum = maxNum - remainder*(Math.pow(10,count));
            maxNum = maxNum + 9*(Math.pow(10,count))
        }
        if(remainder==min){
            minNum = minNum - remainder*(Math.pow(10,count));
        }
        temp = Math.floor(temp / 10);
        count++;
    }
    return maxNum-minNum;
};
minMaxDifference(1023);
function disemvowel(str) {
  let newstr = "";
  let vowelCheck = "aeiouAEIOU";
  for(let i = 0 ; i < str.length ; i++){
      if(!vowelCheck.includes(str.charAt(i)))
        newstr += str.charAt(i);
  }
  return newstr;
}
console.log(disemvowel("This website is for losers LOL!"));

function narcissistic(value) {
  // Code me to return true or false
  let n = value ;
  let p = 0;
  let k = value;
  let ans = 0;
  while(n>0){
    n = Math.floor(n / 10);
    p = p + 1;
  }
  while(k>0){
    ans = ans + Math.pow((k%10),p);
    k = Math.floor(k / 10);
  }
  return ans === value ;
}
console.log(narcissistic(153));

function longest(s1, s2) {
  // your code
  let arr = (s1+s2).split("");
  let charSet = new Set(arr);
  let arr1 = [...charSet];
  arr1.sort();
  return arr1.join("");
}
console.log(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq"));

function accum(s) {
  let ans = '';
  let pointer = 0;
	for(let char of s){
    ans = ans + char.toUpperCase() + char.toLowerCase().repeat(pointer) + '-';
    pointer++;
  }
    return ans.substring(0,ans.length-1);
}
console.log(typeof accum("ZpglnRxqenU"));

function toCamelCase(str){
    return str.replace(/[-_]+(.)?/g, (match, chr) => chr ? chr.toUpperCase() : '');
}

function countBits(n) {
  // Program Me
  let binary = n.toString(2);
    return binary.split('1').length - 1;
}
console.log(countBits(10));

function getCount(str) {
  str.split('').filter(x => 'aeiou'.includes(x)).length;
}

const binaryArrayToNumber = arr => {
  let ans = 0;
  for(let i = arr.length-1 ; i>=0 ; i--){
    ans = ans + (arr[i]===1 ? Math.pow(2,arr.length - i - 1) : 0);
}
  return ans;
};
console.log(binaryArrayToNumber([0,0,0,1]));


function containsAll(str, chars) {
    return [...chars].every(c => str.includes(c));
}
function alphabetPosition(text) {
    return text.toLowerCase().split('').filter(c => c >= 'a' && c <= 'z').map(c => c.charCodeAt(0) - 'a'.charCodeAt(0) + 1).join(' ');
}