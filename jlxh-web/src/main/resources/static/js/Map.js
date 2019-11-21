function getMap() { // 初始化map,给map对象增加方法，使map像Map
    var map = new Object();
    map.put = function(key, value) {
        map[key] = value;
    };
    map.get = function(key) {
        return map[key];
    };
    map.remove = function(key) {
        delete map[key];
    };
    map.keyset = function() {
        var ret = "";
        for (var p in map) {
            if (typeof p == 'string' && p.substring(p.length - 1) == "_") {
                ret += ",";
                ret += p.substring(0, p.length - 1);
            }
        }
        if (ret == "") {
            return ret.split(",");
        } else {
            return ret.substring(1).split(",");
        }
    };
    return map;
}