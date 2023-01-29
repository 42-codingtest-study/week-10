//문제: 1456
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

solution(input);
function solution(input) {
  const [a, b] = input[0].split(" ").map(Number);
  let eratos = Array.from({ length: 10000001 }, (n, i) =>
    i === 1 ? false : true
  );
  for (let i = 2; i < 3163; i++) {
    if (eratos[i]) for (let j = 2; j < 10000002 / i; j++) eratos[i * j] = false;
  }

  let ans = 0;
  const rootB = Math.sqrt(b);
  for (let i = 1; i <= 10000000; i++) {
    if (eratos[i]) {
      let pow = i * i;
      while (pow <= b) {
        if (pow >= a) ans++;
        pow *= i;
      }
    }
  }

  console.log(ans);
}
