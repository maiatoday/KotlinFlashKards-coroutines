Question:

**What is structured concurrency?  Why do we need it? What are the benefits?**

<div class="hint">
  Structured concurrency allows us to manage coroutines so that we can cancel them. This is important because we don't want unneeded coroutines running in the background to use resources or worse case crash the app. Parent coroutines will look after their child coroutines. The parent will either wait for all the children to complete or cancel them if the parent is cancelled.
</div>
