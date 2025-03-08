import { createRouter, createWebHistory } from 'vue-router'
import ProtocolList from '../views/ProtocoloList.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Index',
      component: ProtocolList,
    }
  ],
})

export default router
