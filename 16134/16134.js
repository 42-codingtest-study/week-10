//문제: 16134
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

solution(input);
function solution(input) {
  const [n, k] = input[0].split(" ").map(BigInt);

  combination = (n, k) => {
    let result = BigInt(1);
    for (let i = BigInt(1); i <= k; i++) {
      result = (result * (n - (k - i))) / i;
    }
    return result;
  };
  console.log((combination(n, k) % 1000000007n).toString());
}
