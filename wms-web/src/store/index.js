import vue from 'vue'
import Vuex from 'vuex'
import router,{resetRouter} from "../router";
import createPersistedState from 'vuex-persistedstate'
vue.use(Vuex)

function addNewRoute(menuList) {

    let routes = router.options.routes
    routes.forEach(routeItem=>{
        if (routeItem.path=="/Index") {
            menuList.forEach(menu=> {
                let childRoute = {
                    path: '/' + menu.menuclick,
                    name: menu.menuname,
                    meta: {
                        title: menu.menuname
                    },
                    component: () => import('../components/' +  menu.menucomponent)
                }
                routeItem.children.push(childRoute)
            })
        }
    })
    resetRouter()
    router.addRoutes(routes)
}

const config = {
    // 定义状态
    state: {
        menu:[]
    },

    // getters
    getters: {
        getMenu(state){
            return state.menu
        }
    },

    // 修改state里面的变量
    mutations: {
        setMenu(state,menuList){
            state.menu = menuList
            addNewRoute(menuList)
        },
        setRouter(state,menuList){
            addNewRoute(menuList)
        }
    },

    plugins: [createPersistedState()]

}
export default new Vuex.Store(config);