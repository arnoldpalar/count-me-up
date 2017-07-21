import Vue from 'vue'
import Vuex from 'vuex'
import VueResource from 'vue-resource'
import App from './App.vue'

Vue.use(Vuex)
Vue.use(VueResource)

const state = {
    candidates: [

    ]
}

const store = new Vuex.Store({
    state,
    getters: {
        sortedCandidates: state => state.candidates.sort((a, b) => a.voteCount < b.voteCount ? 1 : (a.voteCount > b.voteCount ? -1 : 0))
    },
    mutations: {
        refreshCandidates(state, candidates) {
            state.candidates = candidates
        }
    },
    actions: {
        refreshCandidates({commit}) {
            Vue.http.get('/rest/count/').then(response => {
                const candidates = [];
                if (response.body) {
                    Object.keys(response.body).forEach(k => candidates.push({id: k, voteCount: response.data[k]}))
                }

                commit('refreshCandidates', candidates)
            }, error => {
                console.log(error.statusText);
            });
        }
    }
})

new Vue({
    el: '#app',
    store,
    render: h => h(App)
})
