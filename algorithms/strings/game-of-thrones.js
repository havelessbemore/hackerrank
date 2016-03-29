//https://www.hackerrank.com/challenges/game-of-thrones
_input = '';
process.stdin.resume();
process.stdin.setEncoding('ascii');
process.stdin.on('data', function(input){
  _input += input;
});

process.stdin.on('end', function(){
  processData(_input);
});

function processData(input){
  console.log(isPalindromePermutation(input) ? 'YES' : 'NO');
}

// Check if input is permutation of a palindrome
// For definition of a palindrome, see: https://en.wikipedia.org/wiki/Palindrome
function isPalindromePermutation(str){
  
  //Track even-ness of letters
  var bits = 0;
  
  //For every character in the input string
  //Get the character's ASCII code and update bits
  var strLen = str.length;
  for(var i = 0; i < strLen; bits = bits ^ (1 << (str.charCodeAt(i++) - 97))){}
  
  //Check if palindrome:
  //   - Iff str length is even, no letter can appear an odd amount of times
  //   - Iff str length is odd, one letter must appear an odd amount of times
  return (bits & (bits - (strLen & 1))) === 0;
}
