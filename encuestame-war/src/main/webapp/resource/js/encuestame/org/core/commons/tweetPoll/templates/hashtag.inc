<div class="hashTagWrapper">
    <div>
        <div id="hashTagSuggest_${id}" dojoType="encuestame.org.core.shared.utils.Suggest"
        label="Add your HashTag"></div>
    </div>
    <div class="wrapperHashTagItems">
        <div dojoAttachPoint="_items"></div>
    </div>
    <div dojoType="dijit.Dialog" id="option_${id}" title="Options" style="width: 400px;">
              <div class="optionAnswerItem">
                    <span class="optionItem">
                        <button dojoType="dijit.form.Button" dojoAttachEvent="onClick:_removeItem">Remove</button>
                    </span>
                    <span class="optionItem">
                        <button dojoType="dijit.form.Button">Show Stats of the HashTag</button>
                    </span>
                    <span class="optionItem">
                        <button dojoType="dijit.form.Button">Search by Tag</button>
                    </span>
              </div>
        </div>
</div>