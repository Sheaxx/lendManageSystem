import Vue from 'vue'
import VueRouter from 'vue-router'
import Freelancer from '../views/freelancer.vue'
import Progress from '../views/progress.vue'
import Client from '../views/client.vue'
import TimeTable from '../views/timeTable.vue'
import Login from '../views/login.vue'
import Home from '../views/home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/home',
    name: 'home',
    component: Home,
    children:[
      {
        path: '/freelancer',
        name: 'freelancer',
        component: Freelancer
      },
      {
        path: '/progress',
        name: 'progress',
        component: Progress
      },
      {
        path: '/client',
        name: 'client',
        component: Client
      },
      {
        path: '/timeTable',
        name: 'timeTable',
        component: TimeTable
      }
    ]
  },
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
