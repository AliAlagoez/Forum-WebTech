<template>
  <div class="home">
    <img alt="FF Logo" src="../assets/Fictionforumlogoss.png" width="250" height="auto" align="" >
    <h1>Welcome to Fiction Forum!</h1>
    <HelloWorld msg=""/>
  </div>
</template>

<script>

// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  }
}
</script>
