# Coroutines in Android

Simulating api requests with Android Coroutines

## Notes and Comments

* Coroutines are not Threads, they are more like jobs inside a thread
* To use a function inside a Coroutine, you need to use the __suspend__ modifier
* The delay function delays the coroutine, not the Thread
* __suspend functions__ wait each other inside the same coroutine 
* CoroutineScope are spaces where the coroutines are grouped. Ex: Main, IO and Default
  * Main Scope for the UI Thread
  * IO Scope for Network Requests/Local Database
  * Default for massive computation. Ex: A big list filtering
* Use the function __withContext__ to change between contexts to run a part of the code inside a coroutine 
* You can chain network requests inside a coroutine

Signing commits/GPG 2...
