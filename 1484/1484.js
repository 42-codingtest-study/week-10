//문제: 1484
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

solution(input);
function solution(input) {
  let n = input[0] * 1;
  //   l -> 과거 몸무게 r -> 현재 몸무게
  //  즉 n = l*l - r*r
  l = 1;
  r = 1;
  let check = false;
  const result = [];
  while (r <= l && l <= 100000) {
    let temp_n = l * l - r * r;
    if (temp_n < n) l++;
    else if (temp_n === n) {
      console.log(l);
      l++;
      check = true;
    } else r++;
  }
  if (!check) console.log(-1);
}
