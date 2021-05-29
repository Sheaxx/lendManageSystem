import Vue from 'vue'
import VueRouter from 'vue-router'
import Freelancer from '../views/freelancer.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/freelancer',
    name: 'freelancer',
    component: Freelancer
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
