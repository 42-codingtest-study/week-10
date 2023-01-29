//문제: 17103
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

solution(input);
function solution(input) {
  let n = input.shift() * 1;

  let large_num = Math.max(...input);
  const check_prime = [];
  for (let i = 0; i < large_num; i++) {
    check_prime.push(true);
  }

  // Find all prime numbers up to n
  check_prime[0] = false;
  check_prime[1] = false;

  for (let m = 2; m <= large_num / 2; m++) {
    if (check_prime[m]) {
      for (let k = 2; k <= large_num / m; k++) {
        check_prime[m * k] = false;
      }
    }
  }
  result = [];
  for (let t = 0; t < input.length; t++) {
    var splited = Number(input[t]);
    var count = 0;
    for (let p = 1; p <= splited / 2; p++) {
      if (check_prime[splited - p] && check_prime[p]) {
        count++;
      }
    }
    result.push(count);
  }
  console.log(result.join("\n").trim());
}
