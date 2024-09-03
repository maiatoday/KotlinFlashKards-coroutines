
Question:

**What is the difference between parallelism and concurrency? Do coroutines run in parallel?**

<div class="hint">
  Coroutines can be paused. Strictly speaking they don't run in parallel. They run concurrently because when one coroutine takes a break and suspends the next coroutine gets a chance to run. If you set your coroutine contexts up to have multiple threads, coroutines could run in parallel but only if the dispatcher that controls the scheduling, schedules coroutines on multiple threads.
</div>



