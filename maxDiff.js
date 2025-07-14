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