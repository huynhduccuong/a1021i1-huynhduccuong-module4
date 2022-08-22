function fibonacci(num) {
    if (num < 0) {
        return -1;
    }
    else if (num == 0 || num == 1) {
        return num;
    }
    else {
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
var sum = 0;
var i = 10;
for (var j = 1; j <= i; j++) {
    console.log(fibonacci(j));
    sum += fibonacci(j);
}
console.log("Tong cua " + i + " so fibonaci la " + sum);
