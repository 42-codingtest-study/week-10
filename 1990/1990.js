//문제: 1990
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

solution(input);

function isPalindrome(num) {
  num = num + "";
  if (num.length === 1) return true;
  if (num === "11") return true;
  if (num.length % 2 === 0) return false;
  let p1 = 0,
    p2 = num.length - 1;
  let flag = true;
  while (p2 >= p1) {
    if (num[p1++] === num[p2--]) {
      continue;
    }
    flag = false;
    break;
  }
  return flag;
}
function is_prime(num) {
  for (let i = 2; i <= Math.sqrt(num); i++) {
    if (num % i === 0) return false;
  }
  return true;
}

function solution(input) {
  let answer = "";
  const [a, b] = input[0].split(" ").map(Number);
  for (let i = a; i <= b; i++) {
    if (i > 10000000) break;
    if (isPalindrome(i) && is_prime(i)) answer += i + "\n";
  }
  answer += "-1";
  console.log(answer);
}
