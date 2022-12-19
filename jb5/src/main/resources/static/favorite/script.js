Vue.createApp({
    data() {
        return {
            get: {
                page: 1,
                rows: 10,
            },
            title: 'Favorite',
            contents: 'this is Favorite List',
            index: {
                total: 0,
                list: [],
            },
            post: {
                title: "",
                contents: "",
            }
        };
    },
        mounted() {
            this.list();
    },
    methods: {
        list() {
            $.get('/favorite/all', this.get)
            .done( res => {
                this.index.list = res;
                //this.index.list.forEach( row => row.created = row.created.substring(0,10));
                console.log(this.index.list);
            });
        },
        save() {
            $.post('/favorite/save', this.post)
            .done( res => {
                this.post = { title: '', contents: '' };
                this.list();
            });
        },
        edit(row) {
            this.post = row;
        },
        remove( id ) {
            $.get('/favorite/delete', { id: id })
            .done( res => { 
                this.list();
                this.$router.go(this.$router.currentRoute);
            });

            
        }
    },
    components: { pagination: m.pagination }
}).mount('#app');