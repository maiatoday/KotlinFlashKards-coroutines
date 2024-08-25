Question:
## What is the difference between parallelism and concurrency? Do coroutines run in parallel?

<div class="hint">
  Coroutines can be paused. Strictly speaking they don't run in parallel. The run concurrently because when one coroutine takes a break and suspends the next coroutine gets a chance to run. If you set your coroutine contexts up to have multiple threads, Coroutines could run in parallel.
</div>



