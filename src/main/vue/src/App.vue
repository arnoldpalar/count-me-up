<template>
    <section class="vote-result-panel">
        <h1>{{ title }}</h1>
        <hr>
        <table>
            <thead>
            <tr>
                <th>Candidate</th>
                <th>Vote</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="candidate in sortedCandidates">
                <td>{{ candidate.id }}</td>
                <td>{{ candidate.voteCount }}</td>
            </tr>
            </tbody>
        </table>
        <button v-on:click="refreshCandidates">Refresh</button>
    </section>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'

    export default {
        name: 'app',
        data() {
            return {
                title: 'Count Me Up',
                interval: null
            }
        },
        computed: mapGetters(['sortedCandidates']),
        methods: mapActions(['refreshCandidates']),
        mounted: function() {
            this.refreshCandidates();

            this.interval = setInterval(function () {
                this.refreshCandidates();
            }.bind(this), 1000);
        },
        beforeDestroy: function() {
            clearInterval(this.interval);
        }
    }
</script>

<style lang="less" scoped>

    .vote-result-panel {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        color: #333;
        max-width: 500px;
        margin: 0 auto;
        border: 1px solid #333;

        h1 {
            text-align: center;
            color: #42b983;
        }

        table {
            width: auto;
            margin: 10px auto;

            th {
                border-bottom: 1px solid #333;
            }
        }
    }

</style>
